package com.uisrael.karateika.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AscensoRequestDTO {

    @NotNull
    private int asc_id_serial;

    @NotNull
    private int alu_id;

    @NotBlank
    private String asc_cinturon;

    @NotNull
    private LocalDate asc_fecha_examen;

    @NotNull
    private LocalDate asc_fecha_ascenso;

    @NotNull
    private double asc_calificacion;

    @NotBlank
    private String asc_evaluador;

    @NotBlank
    private String asc_observacion;

    @NotNull
    private boolean asc_c_generado;
}
