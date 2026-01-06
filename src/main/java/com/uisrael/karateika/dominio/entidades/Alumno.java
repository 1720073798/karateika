package com.uisrael.karateika.dominio.entidades;

import java.io.Serializable;



public class Alumno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private final int alu_id;
	private final String alu_nombre;
	
	public Alumno(int alu_id, String alu_nombre) {
		this.alu_id = alu_id;
		this.alu_nombre = alu_nombre;
	}

	public int getAlu_id() {
		return alu_id;
	}

	public String getAlu_nombre() {
		return alu_nombre;
	}

	@Override
	public String toString() {
		return "Alumno [alu_id=" + alu_id + ", alu_nombre=" + alu_nombre + "]";
	}
}
