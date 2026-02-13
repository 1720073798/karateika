package com.uisrael.karateika.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AscensoRequestDTO {

    private Integer asc_id_serial;

    @NotBlank
    private String asc_cinturon;

    @NotNull
    private LocalDate asc_fecha_examen;

    @NotNull
    private LocalDate asc_fecha_ascenso;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double asc_calificacion;

    @NotBlank
    private String asc_evaluador;

    // observacion puede ser opcional
    private String asc_observacion;

    @NotNull
    private Boolean asc_c_generado;

    private AlumnoRequestDTO fkalumno;

}