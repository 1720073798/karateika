package com.uisrael.karateika.presentacion.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class PagosResponseDTO {

	private int pag_id;
	private LocalDate pag_fecha_pago;
	private String pag_metodo_pago;
	private String pag_numero_recibo;
	private String pag_observacion;
	private BigDecimal pag_monto;
	private String pag_registrado_por;
	private LocalDate pag_fecha_registro;

	private AlumnoResponseDTO fkalumno;
	private ComprobanteResponseDTO fkcomprobante;
	
}
