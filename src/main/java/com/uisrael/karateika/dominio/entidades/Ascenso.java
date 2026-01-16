package com.uisrael.karateika.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import com.uisrael.karateika.infraestructura.persistencias.jpa.AlumnoJpa;

public class Ascenso implements Serializable {

	
		private static final long serialVersionUID = 1L;

		private final int asc_id_serial;
	    private final String asc_cinturon;
	    private final LocalDate asc_fecha_examen;
	    private final LocalDate asc_fecha_ascenso;
	    private final double asc_calificacion;
	    private final String asc_evaluador;
	    private final String asc_observacion;
	    private final boolean asc_c_generado;
	    
	    private final AlumnoJpa fkalumno;

		
		public Ascenso(int asc_id_serial, String asc_cinturon, LocalDate asc_fecha_examen, LocalDate asc_fecha_ascenso,
				double asc_calificacion, String asc_evaluador, String asc_observacion, boolean asc_c_generado,
				AlumnoJpa fkalumno) {
			
			this.asc_id_serial = asc_id_serial;
			this.asc_cinturon = asc_cinturon;
			this.asc_fecha_examen = asc_fecha_examen;
			this.asc_fecha_ascenso = asc_fecha_ascenso;
			this.asc_calificacion = asc_calificacion;
			this.asc_evaluador = asc_evaluador;
			this.asc_observacion = asc_observacion;
			this.asc_c_generado = asc_c_generado;
			this.fkalumno = fkalumno;
		}

		public int getAsc_id_serial() {
			return asc_id_serial;
		}

		public String getAsc_cinturon() {
			return asc_cinturon;
		}

		public LocalDate getAsc_fecha_examen() {
			return asc_fecha_examen;
		}

		public LocalDate getAsc_fecha_ascenso() {
			return asc_fecha_ascenso;
		}

		public double getAsc_calificacion() {
			return asc_calificacion;
		}

		public String getAsc_evaluador() {
			return asc_evaluador;
		}

		public String getAsc_observacion() {
			return asc_observacion;
		}

		public boolean isAsc_c_generado() {
			return asc_c_generado;
		}

		public AlumnoJpa getFkalumno() {
			return fkalumno;
		}

		@Override
		public String toString() {
			return "Ascenso [asc_id_serial=" + asc_id_serial + ", asc_cinturon=" + asc_cinturon + ", asc_fecha_examen="
					+ asc_fecha_examen + ", asc_fecha_ascenso=" + asc_fecha_ascenso + ", asc_calificacion="
					+ asc_calificacion + ", asc_evaluador=" + asc_evaluador + ", asc_observacion=" + asc_observacion
					+ ", asc_c_generado=" + asc_c_generado + ", fkalumno=" + fkalumno + "]";
		}		
	    
}
