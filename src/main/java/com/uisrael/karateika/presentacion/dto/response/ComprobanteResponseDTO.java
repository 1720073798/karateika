package com.uisrael.karateika.presentacion.dto.response;

import java.time.LocalDate;

public class ComprobanteResponseDTO {

	private int com_id;
    private int com_numero;  // ✅ int
    private String com_ruta_archivo;
    private LocalDate com_fecha_subida;
    
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public int getCom_numero() {
		return com_numero;
	}
	public void setCom_numero(int com_numero) {
		this.com_numero = com_numero;
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
