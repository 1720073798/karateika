package com.uisrael.karateika.presentacion.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class AsistenciaResponseDTO {

	private int asi_id;
    private LocalDate asi_fecha;
    private LocalTime asi_hora;
    private String asi_estado;     // ej: "P" (Presente), "F" (Falta)
    private String asi_observacion;
    
    private AlumnoResponseDTO fkalumno;	    
}

