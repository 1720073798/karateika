package com.uisrael.karateika.infraestructura.persistencias.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pagos")
public class PagosJpa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pag_id;

    @Column(name = "pag_mes", nullable = false)
    private int pag_mes;

    @Column(name = "pag_anio", nullable = false)
    private int pag_anio;

    @Column(name = "pag_fecha_pago", columnDefinition = "DATE")
    private LocalDate pag_fecha_pago;

    @Column(name = "pag_metodo_pago", length = 50, nullable = false)
    private String pag_metodo_pago;

    @Column(name = "pag_numero_recibo", length = 50, nullable = true)
    private String pag_numero_recibo;

    @Column(name = "pag_observacion", length = 255, nullable = true)
    private String pag_observacion;

    @Column(name = "pag_monto", precision = 10, scale = 2, nullable = false)
    private BigDecimal pag_monto;

    @Column(name = "pag_registrado_por", length = 100, nullable = false)
    private String pag_registrado_por;

    @Column(name = "pag_fecha_registro", columnDefinition = "DATE")
    private LocalDate pag_fecha_registro;
    
	@ManyToOne
	@JoinColumn(name = "com_id", nullable = false)
	private ComprobanteJpa fkcomprobante;

    @ManyToOne
    @JoinColumn(name = "alu_id", nullable = false)
    private AlumnoJpa fkalumno;
	
}
