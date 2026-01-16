package com.uisrael.karateika.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AscensoRequestDTO {
	@NotBlank
	private final int asc_id_serial;
	@NotBlank
    private final String asc_cinturon;
	@NotBlank
    private final LocalDate asc_fecha_examen;
	@NotBlank
    private final LocalDate asc_fecha_ascenso;
	@NotBlank
    private final double asc_calificacion;
	@NotBlank
    private final String asc_evaluador;
	@NotBlank
    private final String asc_observacion;
	@NotBlank
    private final boolean asc_c_generado;
    
    private final AlumnoRequestDTO fkalumno;
}
