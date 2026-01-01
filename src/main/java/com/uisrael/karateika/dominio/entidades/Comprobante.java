package com.uisrael.karateika.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class Comprobante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 private final int com_id;
	 private final String com_nombre;
	 private final String com_ruta_archivo;
	 private final LocalDate com_fecha_subida;
	 
	 private Comprobante(int com_id, String com_nombre, String com_ruta_archivo, LocalDate com_fecha_subida) {
		this.com_id = com_id;
		this.com_nombre = com_nombre;
		this.com_ruta_archivo = com_ruta_archivo;
		this.com_fecha_subida = com_fecha_subida;
	 }

	 public int getCom_id() {
		 return com_id;
	 }

	 public String getCom_nombre() {
		 return com_nombre;
	 }

	 public String getCom_ruta_archivo() {
		 return com_ruta_archivo;
	 }

	 public LocalDate getCom_fecha_subida() {
		 return com_fecha_subida;
	 }

	 @Override
	 public String toString() {
		return "Comprobante [com_id=" + com_id + ", com_nombre=" + com_nombre + ", com_ruta_archivo=" + com_ruta_archivo
				+ ", com_fecha_subida=" + com_fecha_subida + "]";
	 }
	
	 
}
