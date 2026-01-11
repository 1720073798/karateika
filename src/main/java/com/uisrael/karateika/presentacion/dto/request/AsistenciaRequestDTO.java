package com.uisrael.karateika.presentacion.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AsistenciaRequestDTO {

    @NotNull(message = "El ID de la asistencia es obligatorio")
    private Integer asiId; 

    @NotNull(message = "El ID del alumno es obligatorio")
    private Integer aluId;

    @NotNull(message = "La fecha de asistencia es obligatoria")
    private LocalDate asiFecha;

    @NotNull(message = "La hora de asistencia es obligatoria")
    private LocalTime asiHora;

    @Pattern(regexp = "^[PFJ]$", message = "El estado debe ser 'P' (Presente), 'F' (Falta) o 'J' (Justificada)")
    private String asiEstado = "P";

    private String asiObservacion;
}