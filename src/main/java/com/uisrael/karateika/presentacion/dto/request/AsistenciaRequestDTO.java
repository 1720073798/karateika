package com.uisrael.karateika.presentacion.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AsistenciaRequestDTO {

    @NotNull(message = "El ID de la asistencia es obligatorio")
    private Integer asi_id; 

    @NotNull(message = "El ID del alumno es obligatorio")
    private Integer alu_id;

    @NotNull(message = "La fecha de asistencia es obligatoria")
    private LocalDate asi_fecha;

    @NotNull(message = "La hora de asistencia es obligatoria")
    private LocalTime asi_hora;

    @Pattern(regexp = "^[PFJ]$", message = "El estado debe ser 'P' (Presente), 'F' (Falta) o 'J' (Justificada)")
    private String asi_estado = "P";
    
    @NotBlank
    private String asi_observacion;
}