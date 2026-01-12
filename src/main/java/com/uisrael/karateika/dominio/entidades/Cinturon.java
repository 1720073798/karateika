package com.uisrael.karateika.dominio.entidades;

import java.io.Serializable;

import lombok.Data;

@Data
public class Cinturon implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private final int cin_id;
	private final String cin_nombre;
	private final String cin_nivel;
	private final String cin_descripcion;
	
	public Cinturon(int cin_id, String cin_nombre, String cin_nivel, String cin_descripcion) {
		this.cin_id = cin_id;
		this.cin_nombre = cin_nombre;
		this.cin_nivel = cin_nivel;
		this.cin_descripcion = cin_descripcion;
	}

	public int getCin_id() {
		return cin_id;
	}

	public String getCin_nombre() {
		return cin_nombre;
	}

	public String getCin_nivel() {
		return cin_nivel;
	}

	public String getCin_descripcion() {
		return cin_descripcion;
	}

	@Override
	public String toString() {
		return "Cinturon [cin_id=" + cin_id + ", cin_nombre=" + cin_nombre + ", cin_nivel=" + cin_nivel
				+ ", cin_descripcion=" + cin_descripcion + "]";
	}	

}
