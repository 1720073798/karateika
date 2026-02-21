package com.uisrael.karateika.presentacion.controladores;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.karateika.aplicacion.casouso.entradas.IAlumnoUseCase;
import com.uisrael.karateika.aplicacion.casouso.entradas.IAscensoUseCase;
import com.uisrael.karateika.dominio.entidades.Alumno;
import com.uisrael.karateika.infraestructura.util.PdfGenerator;
import com.uisrael.karateika.presentacion.dto.request.AscensoRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.AlumnoResponseDTO;
import com.uisrael.karateika.presentacion.dto.response.AscensoResponseDTO;
import com.uisrael.karateika.presentacion.mapeadores.IAlumnoDtoMapper;
import com.uisrael.karateika.presentacion.mapeadores.IAscensoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ascensos")
public class AscensoControlador {

    private final IAscensoUseCase ascensoUseCase;
    private final IAscensoDtoMapper mapper;
    private final IAlumnoUseCase alumnoUseCase;
    private final IAlumnoDtoMapper alumnoMapper;

    public AscensoControlador(IAscensoUseCase ascensoUseCase, IAscensoDtoMapper mapper,
                              IAlumnoUseCase alumnoUseCase, IAlumnoDtoMapper alumnoMapper) {
        this.ascensoUseCase = ascensoUseCase;
        this.mapper = mapper;
        this.alumnoUseCase = alumnoUseCase;
        this.alumnoMapper = alumnoMapper;
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
        AscensoResponseDTO guardado = mapper.toResponseDto(
                ascensoUseCase.guardar(
                        mapper.toDomain(request)
                )
        );

        // Actualizar el cinturón actual del alumno asociado (si aplica)
        try {
            if (guardado.getFkalumno() != null && guardado.getFkalumno().getAlu_id() != 0 && guardado.getAsc_cinturon() != null) {
                int idAlumno = guardado.getFkalumno().getAlu_id();
                Alumno alumno = alumnoUseCase.obtenerPorId(idAlumno);
                if (alumno != null) {
                    Alumno actualizado = new Alumno(
                            alumno.getAlu_id(),
                            alumno.getAlu_cedula(),
                            alumno.getAlu_nombre(),
                            alumno.getAlu_apellido(),
                            alumno.getAlu_direccion(),
                            alumno.getAlu_telefono(),
                            alumno.getAlu_email(),
                            alumno.getAlu_fecha_nacimiento(),
                            alumno.getAlu_fecha_ingreso(),
                            alumno.getAlu_cinturon_ingreso(),
                            guardado.getAsc_cinturon(), // actualizar cinturón actual
                            alumno.getAlu_nombre_representante(),
                            alumno.getAlu_telefono_representante(),
                            alumno.getAlu_estado(),
                            alumno.isAlu_alerta_pago(),
                            alumno.getAlu_fecha_creacion(),
                            alumno.getAlu_fecha_modificacion()
                    );
                    alumnoUseCase.guardar(actualizado);
                }
            }
        } catch (Exception ex) {
            // No detener la creación del ascenso por un fallo al actualizar el alumno; loguear en producción
        }

        return guardado;
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

        // Actualizar el cinturón actual del alumno asociado (si aplica)
        try {
            if (guardado.getFkalumno() != null && guardado.getFkalumno().getAlu_id() != 0 && guardado.getAsc_cinturon() != null) {
                int idAlumno = guardado.getFkalumno().getAlu_id();
                Alumno alumno = alumnoUseCase.obtenerPorId(idAlumno);
                if (alumno != null) {
                    Alumno actualizado = new Alumno(
                            alumno.getAlu_id(),
                            alumno.getAlu_cedula(),
                            alumno.getAlu_nombre(),
                            alumno.getAlu_apellido(),
                            alumno.getAlu_direccion(),
                            alumno.getAlu_telefono(),
                            alumno.getAlu_email(),
                            alumno.getAlu_fecha_nacimiento(),
                            alumno.getAlu_fecha_ingreso(),
                            alumno.getAlu_cinturon_ingreso(),
                            guardado.getAsc_cinturon(), // actualizar cinturón actual
                            alumno.getAlu_nombre_representante(),
                            alumno.getAlu_telefono_representante(),
                            alumno.getAlu_estado(),
                            alumno.isAlu_alerta_pago(),
                            alumno.getAlu_fecha_creacion(),
                            alumno.getAlu_fecha_modificacion()
                    );
                    alumnoUseCase.guardar(actualizado);
                }
            }
        } catch (Exception ex) {
            // No detener el flujo por fallo al actualizar alumno; en prod loguear el error
        }

        // Si no se solicitó certificado, devolver el recurso creado normalmente
        if (!guardado.isAsc_c_generado()) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        // Generar PDF con los datos necesarios
        String nombreAlumno = "";
        // Intentar obtener el id del alumno desde el request primero
        if (request.getFkalumno() != null && request.getFkalumno().getAlu_id() != 0) {
            try {
                AlumnoResponseDTO alumno = alumnoMapper.toResponseDto(alumnoUseCase.obtenerPorId(request.getFkalumno().getAlu_id()));
                if (alumno != null) {
                    nombreAlumno = (alumno.getAlu_nombre() != null ? alumno.getAlu_nombre() : "")
                            + " " + (alumno.getAlu_apellido() != null ? alumno.getAlu_apellido() : "");
                }
            } catch (Exception ex) {
                // si falla la carga por alguna razón, intentamos usar lo que vino en guardado
            }
        }

        // Si no obtuvimos el nombre desde el request, intentar desde la respuesta guardada
        if (nombreAlumno.trim().isEmpty() && guardado.getFkalumno() != null) {
            Integer idAlumno = guardado.getFkalumno().getAlu_id();
            if (idAlumno != null && idAlumno != 0) {
                try {
                    AlumnoResponseDTO alumno = alumnoMapper.toResponseDto(alumnoUseCase.obtenerPorId(idAlumno));
                    if (alumno != null) {
                        nombreAlumno = (alumno.getAlu_nombre() != null ? alumno.getAlu_nombre() : "")
                                + " " + (alumno.getAlu_apellido() != null ? alumno.getAlu_apellido() : "");
                    }
                } catch (Exception ex) {
                    // fallback: usar lo que venga en fkalumno
                    nombreAlumno = (guardado.getFkalumno().getAlu_nombre() != null ? guardado.getFkalumno().getAlu_nombre() : "")
                            + " " + (guardado.getFkalumno().getAlu_apellido() != null ? guardado.getFkalumno().getAlu_apellido() : "");
                }
            } else {
                nombreAlumno = (guardado.getFkalumno().getAlu_nombre() != null ? guardado.getFkalumno().getAlu_nombre() : "")
                        + " " + (guardado.getFkalumno().getAlu_apellido() != null ? guardado.getFkalumno().getAlu_apellido() : "");
            }
        }

        String nuevoCinturon = guardado.getAsc_cinturon();
        String fechaAscenso = guardado.getAsc_fecha_ascenso() != null ? guardado.getAsc_fecha_ascenso().format(DateTimeFormatter.ISO_DATE) : "";
        String evaluador = guardado.getAsc_evaluador() != null ? guardado.getAsc_evaluador() : "";

        byte[] pdfBytes;
        try {
            // sanitizar nombre para evitar "null null" o valores literales "null"
            if (nombreAlumno == null) {
                nombreAlumno = "";
            }
            nombreAlumno = nombreAlumno.replaceAll("(?i)null", "").trim();
            if (nombreAlumno.isEmpty()) {
                nombreAlumno = "Nombre no disponible";
            }

            pdfBytes = PdfGenerator.generarCertificado(nombreAlumno.trim(), nuevoCinturon, fechaAscenso, evaluador);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "certificado_ascenso.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
    
	@GetMapping("/buscarid/{idAscenso}")
	public AscensoResponseDTO buscarPorId(@PathVariable int idAscenso) {
		return mapper.toResponseDto(ascensoUseCase.obtenerPorId(idAscenso));
		
	}
    
    
}