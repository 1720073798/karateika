package com.uisrael.karateika.presentacion.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AsistenciaRequestDTO {
	@NotBlank
	private int asi_id;
	@NotBlank
    private LocalDate asi_fecha;
	@NotBlank
    private LocalTime asi_hora;
	@NotBlank
    private String asi_estado;     // ej: "P" (Presente), "F" (Falta)
	@NotBlank
    private String asi_observacion;
	
    private AlumnoRequestDTO fkalumno;
}