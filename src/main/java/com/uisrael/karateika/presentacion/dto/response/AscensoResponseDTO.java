package com.uisrael.karateika.presentacion.dto.response;

import java.time.LocalDate;

public class AscensoResponseDTO {

    private int asc_id_serial;
    private int alu_id;
    private String asc_cinturon;
    private LocalDate asc_fecha_examen;
    private LocalDate asc_fecha_ascenso;
    private double asc_calificacion;
    private String asc_evaluador;
    private String asc_observacion;
    private boolean asc_c_generado;

    public int getAsc_id_serial() {
        return asc_id_serial;
    }

    public void setAsc_id_serial(int asc_id_serial) {
        this.asc_id_serial = asc_id_serial;
    }

    public int getAlu_id() {
        return alu_id;
    }

    public void setAlu_id(int alu_id) {
        this.alu_id = alu_id;
    }

    public String getAsc_cinturon() {
        return asc_cinturon;
    }

    public void setAsc_cinturon(String asc_cinturon) {
        this.asc_cinturon = asc_cinturon;
    }

    public LocalDate getAsc_fecha_examen() {
        return asc_fecha_examen;
    }

    public void setAsc_fecha_examen(LocalDate asc_fecha_examen) {
        this.asc_fecha_examen = asc_fecha_examen;
    }

    public LocalDate getAsc_fecha_ascenso() {
        return asc_fecha_ascenso;
    }

    public void setAsc_fecha_ascenso(LocalDate asc_fecha_ascenso) {
        this.asc_fecha_ascenso = asc_fecha_ascenso;
    }

    public double getAsc_calificacion() {
        return asc_calificacion;
    }

    public void setAsc_calificacion(double asc_calificacion) {
        this.asc_calificacion = asc_calificacion;
    }

    public String getAsc_evaluador() {
        return asc_evaluador;
    }

    public void setAsc_evaluador(String asc_evaluador) {
        this.asc_evaluador = asc_evaluador;
    }

    public String getAsc_observacion() {
        return asc_observacion;
    }

    public void setAsc_observacion(String asc_observacion) {
        this.asc_observacion = asc_observacion;
    }

    public boolean isAsc_c_generado() {
        return asc_c_generado;
    }

    public void setAsc_c_generado(boolean asc_c_generado) {
        this.asc_c_generado = asc_c_generado;
    }
}
