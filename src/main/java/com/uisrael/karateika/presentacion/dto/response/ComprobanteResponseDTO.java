package com.uisrael.karateika.presentacion.dto.response;

import java.time.LocalDate;

public class ComprobanteResponseDTO {

	 private int com_id;
	 private String com_nombre;
	 private String com_ruta_archivo;
	 private LocalDate com_fecha_subida;
	 public int getCom_id() {
		 return com_id;
	 }
	 public void setCom_id(int com_id) {
		 this.com_id = com_id;
	 }
	 public String getCom_nombre() {
		 return com_nombre;
	 }
	 public void setCom_nombre(String com_nombre) {
		 this.com_nombre = com_nombre;
	 }
	 public String getCom_ruta_archivo() {
		 return com_ruta_archivo;
	 }
	 public void setCom_ruta_archivo(String com_ruta_archivo) {
		 this.com_ruta_archivo = com_ruta_archivo;
	 }
	 public LocalDate getCom_fecha_subida() {
		 return com_fecha_subida;
	 }
	 public void setCom_fecha_subida(LocalDate com_fecha_subida) {
		 this.com_fecha_subida = com_fecha_subida;
	 }

	 
}
