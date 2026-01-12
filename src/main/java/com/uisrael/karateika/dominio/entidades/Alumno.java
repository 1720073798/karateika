package com.uisrael.karateika.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;



public class Alumno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private final int alu_id;
	private final String alu_cedula;
	private final String alu_nombre;
	private final String alu_apellido;
	private final String alu_direccion;
	private final String alu_telefono;
	private final String alu_email;
	private final LocalDate alu_fecha_nacimiento;
	private final LocalDate alu_fecha_ingreso;
	private final String alu_cinturon_ingreso;
	private final String alu_cinturon_actual;
	private final String alu_nombre_representante;
	private final String alu_telefono_representante;
	private final char alu_estado;
	private final boolean alu_alerta_pago;
	private final LocalDate alu_fecha_creacion;
	private final LocalDate alu_fecha_modificacion;
	


	public Alumno(int alu_id, String alu_cedula, String alu_nombre, String alu_apellido, String alu_direccion,
			String alu_telefono, String alu_email, LocalDate alu_fecha_nacimiento, LocalDate alu_fecha_ingreso,
			String alu_cinturon_ingreso, String alu_cinturon_actual, String alu_nombre_representante,
			String alu_telefono_representante, char alu_estado, boolean alu_alerta_pago, LocalDate alu_fecha_creacion,
			LocalDate alu_fecha_modificacion) {
		this.alu_id = alu_id;
		this.alu_cedula = alu_cedula;
		this.alu_nombre = alu_nombre;
		this.alu_apellido = alu_apellido;
		this.alu_direccion = alu_direccion;
		this.alu_telefono = alu_telefono;
		this.alu_email = alu_email;
		this.alu_fecha_nacimiento = alu_fecha_nacimiento;
		this.alu_fecha_ingreso = alu_fecha_ingreso;
		this.alu_cinturon_ingreso = alu_cinturon_ingreso;
		this.alu_cinturon_actual = alu_cinturon_actual;
		this.alu_nombre_representante = alu_nombre_representante;
		this.alu_telefono_representante = alu_telefono_representante;
		this.alu_estado = alu_estado;
		this.alu_alerta_pago = alu_alerta_pago;
		this.alu_fecha_creacion = alu_fecha_creacion;
		this.alu_fecha_modificacion = alu_fecha_modificacion;
	}



	public int getAlu_id() {
		return alu_id;
	}



	public String getAlu_cedula() {
		return alu_cedula;
	}



	public String getAlu_nombre() {
		return alu_nombre;
	}



	public String getAlu_apellido() {
		return alu_apellido;
	}



	public String getAlu_direccion() {
		return alu_direccion;
	}



	public String getAlu_telefono() {
		return alu_telefono;
	}



	public String getAlu_email() {
		return alu_email;
	}



	public LocalDate getAlu_fecha_nacimiento() {
		return alu_fecha_nacimiento;
	}



	public LocalDate getAlu_fecha_ingreso() {
		return alu_fecha_ingreso;
	}



	public String getAlu_cinturon_ingreso() {
		return alu_cinturon_ingreso;
	}



	public String getAlu_cinturon_actual() {
		return alu_cinturon_actual;
	}



	public String getAlu_nombre_representante() {
		return alu_nombre_representante;
	}



	public String getAlu_telefono_representante() {
		return alu_telefono_representante;
	}



	public char getAlu_estado() {
		return alu_estado;
	}



	public boolean isAlu_alerta_pago() {
		return alu_alerta_pago;
	}



	public LocalDate getAlu_fecha_creacion() {
		return alu_fecha_creacion;
	}



	public LocalDate getAlu_fecha_modificacion() {
		return alu_fecha_modificacion;
	}



	@Override
	public String toString() {
		return "Alumno [alu_id=" + alu_id + ", alu_cedula=" + alu_cedula + ", alu_nombre=" + alu_nombre
				+ ", alu_apellido=" + alu_apellido + ", alu_direccion=" + alu_direccion + ", alu_telefono="
				+ alu_telefono + ", alu_email=" + alu_email + ", alu_fecha_nacimiento=" + alu_fecha_nacimiento
				+ ", alu_fecha_ingreso=" + alu_fecha_ingreso + ", alu_cinturon_ingreso=" + alu_cinturon_ingreso
				+ ", alu_cinturon_actual=" + alu_cinturon_actual + ", alu_nombre_representante="
				+ alu_nombre_representante + ", alu_telefono_representante=" + alu_telefono_representante
				+ ", alu_estado=" + alu_estado + ", alu_alerta_pago=" + alu_alerta_pago + ", alu_fecha_creacion="
				+ alu_fecha_creacion + ", alu_fecha_modificacion=" + alu_fecha_modificacion + "]";
	}


}

