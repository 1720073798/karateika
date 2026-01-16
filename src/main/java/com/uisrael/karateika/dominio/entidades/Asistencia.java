package com.uisrael.karateika.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import com.uisrael.karateika.infraestructura.persistencias.jpa.AlumnoJpa;

public class Asistencia implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private final int asi_id;
    private final LocalDate asi_fecha;
    private final LocalTime asi_hora;
    private final String asi_estado;     // ej: "P" (Presente), "F" (Falta)
    private final String asi_observacion;
    
    private AlumnoJpa fkalumno;

	public Asistencia(int asi_id, LocalDate asi_fecha, LocalTime asi_hora, String asi_estado, String asi_observacion,
			AlumnoJpa fkalumno) {
		
		this.asi_id = asi_id;
		this.asi_fecha = asi_fecha;
		this.asi_hora = asi_hora;
		this.asi_estado = asi_estado;
		this.asi_observacion = asi_observacion;
		this.fkalumno = fkalumno;
	}

	public AlumnoJpa getFkalumno() {
		return fkalumno;
	}

	public void setFkalumno(AlumnoJpa fkalumno) {
		this.fkalumno = fkalumno;
	}

	public int getAsi_id() {
		return asi_id;
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
		return "Asistencia [asi_id=" + asi_id + ", asi_fecha=" + asi_fecha + ", asi_hora=" + asi_hora + ", asi_estado="
				+ asi_estado + ", asi_observacion=" + asi_observacion + ", fkalumno=" + fkalumno + "]";
	}
	
}

