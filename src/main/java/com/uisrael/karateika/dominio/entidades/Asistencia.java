package com.uisrael.karateika.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Asistencia implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private final int asi_id;
    private final int alu_id;            // FK a Alumno
    private final LocalDate asi_fecha;
    private final LocalTime asi_hora;
    private final String asi_estado;     // ej: "P" (Presente), "F" (Falta)
    private final String asi_observacion;
	public Asistencia(int asi_id, int alu_id, LocalDate asi_fecha, LocalTime asi_hora, String asi_estado,
			String asi_observacion) {
		
		this.asi_id = asi_id;
		this.alu_id = alu_id;
		this.asi_fecha = asi_fecha;
		this.asi_hora = asi_hora;
		this.asi_estado = asi_estado;
		this.asi_observacion = asi_observacion;
	}
	public int getAsi_id() {
		return asi_id;
	}
	public int getAlu_id() {
		return alu_id;
	}
	public LocalDate getAsi_fecha() {
		return asi_fecha;
	}
	public LocalTime getAsi_hora() {
		return asi_hora;
	}
	public String getAsi_estado() {
		return asi_estado;
	}
	public String getAsi_observacion() {
		return asi_observacion;
	}
	@Override
	public String toString() {
		return "Asistencia [asi_id=" + asi_id + ", alu_id=" + alu_id + ", asi_fecha=" + asi_fecha + ", asi_hora="
				+ asi_hora + ", asi_estado=" + asi_estado + ", asi_observacion=" + asi_observacion + "]";
	}

	
}

