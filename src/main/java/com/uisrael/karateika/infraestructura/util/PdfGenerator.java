package com.uisrael.karateika.infraestructura.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfGenerator {

    public static byte[] generarCertificado(String nombreAlumno, String nuevoCinturon, String fechaAscenso, String evaluador) throws IOException {
        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            doc.addPage(page);

            try (PDPageContentStream contents = new PDPageContentStream(doc, page)) {
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
            }

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                doc.save(baos);
                return baos.toByteArray();
            }
        }
    }
}