package com.uisrael.karateika.presentacion.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class AsistenciaResponseDTO {

    private Integer asiId;
    private Integer aluId;
    private LocalDate asiFecha;
    private LocalTime asiHora;
    private String asiEstado;
    private String asiObservacion;
	public Integer getAsiId() {
		return asiId;
	}
	public void setAsiId(Integer asiId) {
		this.asiId = asiId;
	}
	public Integer getAluId() {
		return aluId;
	}
	public void setAluId(Integer aluId) {
		this.aluId = aluId;
	}
	public LocalDate getAsiFecha() {
		return asiFecha;
	}
	public void setAsiFecha(LocalDate asiFecha) {
		this.asiFecha = asiFecha;
	}
	public LocalTime getAsiHora() {
		return asiHora;
	}
	public void setAsiHora(LocalTime asiHora) {
		this.asiHora = asiHora;
	}
	public String getAsiEstado() {
		return asiEstado;
	}
	public void setAsiEstado(String asiEstado) {
		this.asiEstado = asiEstado;
	}
	public String getAsiObservacion() {
		return asiObservacion;
	}
	public void setAsiObservacion(String asiObservacion) {
		this.asiObservacion = asiObservacion;
	}
    
}

