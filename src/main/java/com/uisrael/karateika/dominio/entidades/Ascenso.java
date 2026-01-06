package com.uisrael.karateika.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class Ascenso implements Serializable {

	
		private static final long serialVersionUID = 1L;

		private final int asc_id_serial;
	    private final int alu_id;
	    private final String asc_cinturon;
	    private final LocalDate asc_fecha_examen;
	    private final LocalDate asc_fecha_ascenso;
	    private final double asc_calificacion;
	    private final String asc_evaluador;
	    private final String asc_observacion;
	    private final boolean asc_c_generado;
	    
		public Ascenso(int asc_id_serial, int alu_id, String asc_cinturon, LocalDate asc_fecha_examen,
				LocalDate asc_fecha_ascenso, double asc_calificacion, String asc_evaluador, String asc_observacion,
				boolean asc_c_generado) {
			
			super();
			this.asc_id_serial = asc_id_serial;
			this.alu_id = alu_id;
			this.asc_cinturon = asc_cinturon;
			this.asc_fecha_examen = asc_fecha_examen;
			this.asc_fecha_ascenso = asc_fecha_ascenso;
			this.asc_calificacion = asc_calificacion;
			this.asc_evaluador = asc_evaluador;
			this.asc_observacion = asc_observacion;
			this.asc_c_generado = asc_c_generado;
		}

		public int getAsc_id_serial() {
			return asc_id_serial;
		}

		public int getAlu_id() {
			return alu_id;
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

		@Override
		public String toString() {
			return "Ascenso [asc_id_serial=" + asc_id_serial + ", alu_id=" + alu_id + ", asc_cinturon=" + asc_cinturon
					+ ", asc_fecha_examen=" + asc_fecha_examen + ", asc_fecha_ascenso=" + asc_fecha_ascenso
					+ ", asc_calificacion=" + asc_calificacion + ", asc_evaluador=" + asc_evaluador
					+ ", asc_observacion=" + asc_observacion + ", asc_c_generado=" + asc_c_generado + "]";
		}

		
	
	    
}
