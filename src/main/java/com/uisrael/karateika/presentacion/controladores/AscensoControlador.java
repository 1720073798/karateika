package com.uisrael.karateika.presentacion.controladores;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.karateika.aplicacion.casouso.entradas.IAscensoUseCase;
import com.uisrael.karateika.infraestructura.util.PdfGenerator;
import com.uisrael.karateika.presentacion.dto.request.AscensoRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.AscensoResponseDTO;
import com.uisrael.karateika.presentacion.mapeadores.IAscensoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ascensos")
public class AscensoControlador {

    private final IAscensoUseCase ascensoUseCase;
    private final IAscensoDtoMapper mapper;

    public AscensoControlador(IAscensoUseCase ascensoUseCase, IAscensoDtoMapper mapper) {
        this.ascensoUseCase = ascensoUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<AscensoResponseDTO> listar() {
        return ascensoUseCase.listarTodos()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AscensoResponseDTO crear(@Valid @RequestBody AscensoRequestDTO request) {
        return mapper.toResponseDto(
                ascensoUseCase.guardar(
                        mapper.toDomain(request)
                )
        );
    }

    // Nuevo endpoint: guarda y si se solicita genera y devuelve certificado PDF
    @PostMapping(path = "/certificado", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> crearYDescargarCertificado(@Valid @RequestBody AscensoRequestDTO request) {
        // Guardar el ascenso
        AscensoResponseDTO guardado = mapper.toResponseDto(
                ascensoUseCase.guardar(
                        mapper.toDomain(request)
                )
        );

        // Si no se solicitó certificado, devolver el recurso creado normalmente
        if (!guardado.isAsc_c_generado()) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        // Generar PDF con los datos necesarios
        String nombreAlumno = "";
        if (guardado.getFkalumno() != null) {
            nombreAlumno = guardado.getFkalumno().getAlu_nombre() + " " + guardado.getFkalumno().getAlu_apellido();
        }
        String nuevoCinturon = guardado.getAsc_cinturon();
        String fechaAscenso = guardado.getAsc_fecha_ascenso() != null ? guardado.getAsc_fecha_ascenso().format(DateTimeFormatter.ISO_DATE) : "";
        String evaluador = guardado.getAsc_evaluador() != null ? guardado.getAsc_evaluador() : "";

        byte[] pdfBytes;
        try {
            pdfBytes = PdfGenerator.generarCertificado(nombreAlumno, nuevoCinturon, fechaAscenso, evaluador);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "certificado_ascenso.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}