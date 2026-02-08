package com.uisrael.karateika.dominio.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.uisrael.karateika.infraestructura.persistencias.jpa.AlumnoJpa;
import com.uisrael.karateika.infraestructura.persistencias.jpa.ComprobanteJpa;

public class Pagos implements Serializable{

	private static final long serialVersionUID = 1L;
	 
	private final int pag_id;
    private final LocalDate pag_fecha_pago;
    private final String pag_metodo_pago;
    private final String pag_numero_recibo;
    private final String pag_observacion;
    private final BigDecimal pag_monto;
    private final String pag_registrado_por;
    private final LocalDate pag_fecha_registro; 

    private ComprobanteJpa fkcomprobante;
    private AlumnoJpa fkalumno;
    
	public Pagos(int pag_id, LocalDate pag_fecha_pago, String pag_metodo_pago, String pag_numero_recibo,
			String pag_observacion, BigDecimal pag_monto, String pag_registrado_por, LocalDate pag_fecha_registro,
			ComprobanteJpa fkcomprobante, AlumnoJpa fkalumno) {
		super();
		this.pag_id = pag_id;
		this.pag_fecha_pago = pag_fecha_pago;
		this.pag_metodo_pago = pag_metodo_pago;
		this.pag_numero_recibo = pag_numero_recibo;
		this.pag_observacion = pag_observacion;
		this.pag_monto = pag_monto;
		this.pag_registrado_por = pag_registrado_por;
		this.pag_fecha_registro = pag_fecha_registro;
		this.fkcomprobante = fkcomprobante;
		this.fkalumno = fkalumno;
	}

	public ComprobanteJpa getFkcomprobante() {
		return fkcomprobante;
	}

	public void setFkcomprobante(ComprobanteJpa fkcomprobante) {
		this.fkcomprobante = fkcomprobante;
	}

	public AlumnoJpa getFkalumno() {
		return fkalumno;
	}

	public void setFkalumno(AlumnoJpa fkalumno) {
		this.fkalumno = fkalumno;
	}

	public int getPag_id() {
		return pag_id;
	}

	public LocalDate getPag_fecha_pago() {
		return pag_fecha_pago;
	}

	public String getPag_metodo_pago() {
		return pag_metodo_pago;
	}

	public String getPag_numero_recibo() {
		return pag_numero_recibo;
	}

	public String getPag_observacion() {
		return pag_observacion;
	}

	public BigDecimal getPag_monto() {
		return pag_monto;
	}

	public String getPag_registrado_por() {
		return pag_registrado_por;
	}

	public LocalDate getPag_fecha_registro() {
		return pag_fecha_registro;
	}

	@Override
	public String toString() {
		return "Pagos [pag_id=" + pag_id + ", pag_fecha_pago=" + pag_fecha_pago + ", pag_metodo_pago=" + pag_metodo_pago
				+ ", pag_numero_recibo=" + pag_numero_recibo + ", pag_observacion=" + pag_observacion + ", pag_monto="
				+ pag_monto + ", pag_registrado_por=" + pag_registrado_por + ", pag_fecha_registro="
				+ pag_fecha_registro + ", fkcomprobante=" + fkcomprobante + ", fkalumno=" + fkalumno + "]";
	}
	
	
	
	
}
