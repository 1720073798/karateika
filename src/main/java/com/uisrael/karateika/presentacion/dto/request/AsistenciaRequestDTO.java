package com.uisrael.karateika.presentacion.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AsistenciaRequestDTO {
	private Integer asi_id; // id opcional; lo puede asignar el backend

	@NotNull
    private LocalDate asi_fecha;

	@NotNull
    private LocalTime asi_hora;

	@NotBlank
    private String asi_estado;     // ej: "P" (Presente), "F" (Falta)

    private String asi_observacion;
    
    private AlumnoRequestDTO fkalumno;
}