package com.uisrael.karateika.infraestructura.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PdfGenerator {

    public static byte[] generarCertificado(String nombreAlumno, String nuevoCinturon, String fechaAscenso, String evaluador) throws IOException {
        // sanitize inputs
        if (nombreAlumno == null) nombreAlumno = "";
        if (nuevoCinturon == null) nuevoCinturon = "";
        if (fechaAscenso == null) fechaAscenso = "";
        if (evaluador == null) evaluador = "";

        nombreAlumno = nombreAlumno.replaceAll("(?i)null", "").trim();
        if (nombreAlumno.isEmpty()) nombreAlumno = "Nombre no disponible";

        try (PDDocument doc = new PDDocument()) {
            // Try to load template image from resources
            InputStream imgStream = PdfGenerator.class.getResourceAsStream("/templates/certificado.png");
            PDPage page;
            PDPageContentStream contents = null;
            try {
                if (imgStream != null) {
                    byte[] imgBytes = imgStream.readAllBytes();
                    PDImageXObject pdImage = PDImageXObject.createFromByteArray(doc, imgBytes, "certificado");
                    float imgWidth = pdImage.getWidth();
                    float imgHeight = pdImage.getHeight();

                    // create page sized to image (points)
                    PDRectangle rect = new PDRectangle(imgWidth, imgHeight);
                    page = new PDPage(rect);
                    doc.addPage(page);

                    contents = new PDPageContentStream(doc, page);
                    // draw image covering whole page
                    contents.drawImage(pdImage, 0, 0, imgWidth, imgHeight);

                    // Attempt to load an embedded TTF font for better unicode support if available
                    PDType0Font font = null;
                    InputStream fontStream = PdfGenerator.class.getResourceAsStream("/fonts/DejaVuSans.ttf"); // optional font in resources
                    try {
                        if (fontStream != null) {
                            font = PDType0Font.load(doc, fontStream, true);
                        }
                    } catch (Exception ex) {
                        font = null;
                    } finally {
                        if (fontStream != null) fontStream.close();
                    }

                    // Determine font to use (PDType0Font if available, otherwise a Type1 font)
                    PDFont usedFontForName = (font != null) ? font : PDType1Font.HELVETICA_BOLD;
                    PDFont usedFontForBody = (font != null) ? font : PDType1Font.HELVETICA;

                    // --- Draw NAME centered horizontally ---
                    float nameFontSize = 50f; // adjust size if needed
                    // compute text width in points: (getStringWidth returns 1/1000 text units)
                    float textWidth = usedFontForName.getStringWidth(nombreAlumno) / 1000f * nameFontSize;
                    float xCentered = (imgWidth - textWidth) / 2f;
                    float yName = imgHeight - 530f; // distance from bottom; to place relative to top use imgHeight - desiredTopOffset

                    contents.beginText();
                    contents.setFont(usedFontForName, nameFontSize);
                    contents.newLineAtOffset(xCentered, yName);
                    contents.showText(nombreAlumno);
                    contents.endText();

                    // --- Draw other fields (left-aligned) ---
                    float bodyFontSize = 40f;
                    float leftX = 330f; // tweak this value horizontally

                    // Cinturón
                    contents.beginText();
                    contents.setFont(usedFontForBody, bodyFontSize);
                    contents.newLineAtOffset(leftX, imgHeight - 700f);
                    contents.showText(nuevoCinturon);
                    contents.endText();

                    // Fecha
                    contents.beginText();
                    contents.setFont(usedFontForBody, bodyFontSize);
                    contents.newLineAtOffset(leftX, imgHeight - 1050f);
                    contents.showText("DATE: " + fechaAscenso);
                    contents.endText();

                    // Evaluador (firma) - right-ish bottom
                    float evalFontSize = 24f;
                    contents.beginText();
                    contents.setFont((font != null) ? font : PDType1Font.HELVETICA_OBLIQUE, evalFontSize);
                    // place evaluator near bottom-right; tweak offsets as needed
                    contents.newLineAtOffset(imgWidth - 900f, 330f);
                    contents.showText(evaluador);
                    contents.endText();
                    
                    String nombreQuemado = "CLUB IKA-30398";

                    contents.beginText();
                    contents.setFont((font != null) ? font : PDType1Font.HELVETICA, 24f);
                    // un poco más abajo en Y
                    contents.newLineAtOffset(imgWidth - 350f, 330f);
                    contents.showText(nombreQuemado);
                    contents.endText();
                    
                    contents.close();
                } else {
                    // fallback: no template image found, create simple text-only PDF
                    page = new PDPage();
                    doc.addPage(page);
                    contents = new PDPageContentStream(doc, page);

                    contents.beginText();
                    contents.setFont(PDType1Font.HELVETICA_BOLD, 18);
                    contents.newLineAtOffset(70, 700);
                    contents.showText("CERTIFICADO DE ASCENSO");
                    contents.endText();

                    contents.beginText();
                    contents.setFont(PDType1Font.HELVETICA, 12);
                    contents.newLineAtOffset(70, 660);
                    contents.showText("Se certifica que: " + nombreAlumno);
                    contents.endText();

                    contents.beginText();
                    contents.setFont(PDType1Font.HELVETICA, 12);
                    contents.newLineAtOffset(70, 640);
                    contents.showText("Ha ascendido al cinturón: " + nuevoCinturon);
                    contents.endText();

                    contents.beginText();
                    contents.setFont(PDType1Font.HELVETICA, 12);
                    contents.newLineAtOffset(70, 620);
                    contents.showText("Fecha de ascenso: " + fechaAscenso);
                    contents.endText();

                    contents.beginText();
                    contents.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
                    contents.newLineAtOffset(70, 580);
                    contents.showText("Atentamente,");
                    contents.endText();

                    contents.beginText();
                    contents.setFont(PDType1Font.HELVETICA_BOLD, 12);
                    contents.newLineAtOffset(70, 560);
                    contents.showText(evaluador);
                    contents.endText();

                    contents.close();
                }
            } finally {
                if (imgStream != null) imgStream.close();
                if (contents != null) contents.close();
            }

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                doc.save(baos);
                return baos.toByteArray();
            }
        }
    }
}