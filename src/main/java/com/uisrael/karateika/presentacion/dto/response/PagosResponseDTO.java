package com.uisrael.karateika.presentacion.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;


public class PagosResponseDTO {

	private int pag_id;
	private int pag_mes;
	private int pag_anio;
	private LocalDate pag_fecha_pago;
	private String pag_metodo_pago;
	private String pag_numero_recibo;
	private String pag_observacion;
	private BigDecimal pag_monto;
	private String pag_registrado_por;
	private LocalDate pag_fecha_registro;
	
	private AlumnoResponseDTO fkalumno;
	private ComprobanteResponseDTO fkcomprobante;
	
	public int getPag_id() {
		return pag_id;
	}
	public void setPag_id(int pag_id) {
		this.pag_id = pag_id;
	}
	public int getPag_mes() {
		return pag_mes;
	}
	public void setPag_mes(int pag_mes) {
		this.pag_mes = pag_mes;
	}
	public int getPag_anio() {
		return pag_anio;
	}
	public void setPag_anio(int pag_anio) {
		this.pag_anio = pag_anio;
	}
	public LocalDate getPag_fecha_pago() {
		return pag_fecha_pago;
	}
	public void setPag_fecha_pago(LocalDate pag_fecha_pago) {
		this.pag_fecha_pago = pag_fecha_pago;
	}
	public String getPag_metodo_pago() {
		return pag_metodo_pago;
	}
	public void setPag_metodo_pago(String pag_metodo_pago) {
		this.pag_metodo_pago = pag_metodo_pago;
	}
	public String getPag_numero_recibo() {
		return pag_numero_recibo;
	}
	public void setPag_numero_recibo(String pag_numero_recibo) {
		this.pag_numero_recibo = pag_numero_recibo;
	}
	public String getPag_observacion() {
		return pag_observacion;
	}
	public void setPag_observacion(String pag_observacion) {
		this.pag_observacion = pag_observacion;
	}
	public BigDecimal getPag_monto() {
		return pag_monto;
	}
	public void setPag_monto(BigDecimal pag_monto) {
		this.pag_monto = pag_monto;
	}
	public String getPag_registrado_por() {
		return pag_registrado_por;
	}
	public void setPag_registrado_por(String pag_registrado_por) {
		this.pag_registrado_por = pag_registrado_por;
	}
	public LocalDate getPag_fecha_registro() {
		return pag_fecha_registro;
	}
	public void setPag_fecha_registro(LocalDate pag_fecha_registro) {
		this.pag_fecha_registro = pag_fecha_registro;
	}
	public AlumnoResponseDTO getFkalumno() {
		return fkalumno;
	}
	public void setFkalumno(AlumnoResponseDTO fkalumno) {
		this.fkalumno = fkalumno;
	}
	public ComprobanteResponseDTO getFkcomprobante() {
		return fkcomprobante;
	}
	public void setFkcomprobante(ComprobanteResponseDTO fkcomprobante) {
		this.fkcomprobante = fkcomprobante;
	}

}
