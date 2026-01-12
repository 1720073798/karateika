package com.uisrael.karateika.presentacion.dto.response;

import java.time.LocalDate;

public class AlumnoResponseDTO {
	private int alu_id;
	private String alu_cedula;
	private String alu_nombre;
	private String alu_apellido;
	private String alu_direccion;
	private String alu_telefono;
	private String alu_email;
	private LocalDate alu_fecha_nacimiento;
	private LocalDate alu_fecha_ingreso;
	private String alu_cinturon_ingreso;
	private String alu_cinturon_actual;
	private String alu_nombre_representante;
	private String alu_telefono_representante;
	private char alu_estado;
	private boolean alu_alerta_pago;
	private LocalDate alu_fecha_creacion;
	private LocalDate alu_fecha_modificacion;
	
	public int getAlu_id() {
		return alu_id;
	}
	public void setAlu_id(int alu_id) {
		this.alu_id = alu_id;
	}
	public String getAlu_cedula() {
		return alu_cedula;
	}
	public void setAlu_cedula(String alu_cedula) {
		this.alu_cedula = alu_cedula;
	}
	public String getAlu_nombre() {
		return alu_nombre;
	}
	public void setAlu_nombre(String alu_nombre) {
		this.alu_nombre = alu_nombre;
	}
	public String getAlu_apellido() {
		return alu_apellido;
	}
	public void setAlu_apellido(String alu_apellido) {
		this.alu_apellido = alu_apellido;
	}
	public String getAlu_direccion() {
		return alu_direccion;
	}
	public void setAlu_direccion(String alu_direccion) {
		this.alu_direccion = alu_direccion;
	}
	public String getAlu_telefono() {
		return alu_telefono;
	}
	public void setAlu_telefono(String alu_telefono) {
		this.alu_telefono = alu_telefono;
	}
	public String getAlu_email() {
		return alu_email;
	}
	public void setAlu_email(String alu_email) {
		this.alu_email = alu_email;
	}
	public LocalDate getAlu_fecha_nacimiento() {
		return alu_fecha_nacimiento;
	}
	public void setAlu_fecha_nacimiento(LocalDate alu_fecha_nacimiento) {
		this.alu_fecha_nacimiento = alu_fecha_nacimiento;
	}
	public LocalDate getAlu_fecha_ingreso() {
		return alu_fecha_ingreso;
	}
	public void setAlu_fecha_ingreso(LocalDate alu_fecha_ingreso) {
		this.alu_fecha_ingreso = alu_fecha_ingreso;
	}
	public String getAlu_cinturon_ingreso() {
		return alu_cinturon_ingreso;
	}
	public void setAlu_cinturon_ingreso(String alu_cinturon_ingreso) {
		this.alu_cinturon_ingreso = alu_cinturon_ingreso;
	}
	public String getAlu_cinturon_actual() {
		return alu_cinturon_actual;
	}
	public void setAlu_cinturon_actual(String alu_cinturon_actual) {
		this.alu_cinturon_actual = alu_cinturon_actual;
	}
	public String getAlu_nombre_representante() {
		return alu_nombre_representante;
	}
	public void setAlu_nombre_representante(String alu_nombre_representante) {
		this.alu_nombre_representante = alu_nombre_representante;
	}
	public String getAlu_telefono_representante() {
		return alu_telefono_representante;
	}
	public void setAlu_telefono_representante(String alu_telefono_representante) {
		this.alu_telefono_representante = alu_telefono_representante;
	}
	public char getAlu_estado() {
		return alu_estado;
	}
	public void setAlu_estado(char alu_estado) {
		this.alu_estado = alu_estado;
	}
	public boolean isAlu_alerta_pago() {
		return alu_alerta_pago;
	}
	public void setAlu_alerta_pago(boolean alu_alerta_pago) {
		this.alu_alerta_pago = alu_alerta_pago;
	}
	public LocalDate getAlu_fecha_creacion() {
		return alu_fecha_creacion;
	}
	public void setAlu_fecha_creacion(LocalDate alu_fecha_creacion) {
		this.alu_fecha_creacion = alu_fecha_creacion;
	}
	public LocalDate getAlu_fecha_modificacion() {
		return alu_fecha_modificacion;
	}
	public void setAlu_fecha_modificacion(LocalDate alu_fecha_modificacion) {
		this.alu_fecha_modificacion = alu_fecha_modificacion;
	}	
	
	
}
