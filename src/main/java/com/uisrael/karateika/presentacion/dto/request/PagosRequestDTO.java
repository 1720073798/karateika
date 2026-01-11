package com.uisrael.karateika.presentacion.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PagosRequestDTO {

	@NotBlank
	private int pag_id;
	
	@NotBlank
	private int com_id;
	
	@NotBlank
	private int alu_id;
	
	@NotBlank
	private int pag_mes;
	
	@NotBlank
	private int pag_anio;
	
	@NotBlank
	private LocalDate pag_fecha_pago;
	
	@NotBlank
	private String pag_metodo_pago;
	
	@NotBlank
	private String pag_numero_recibo;
	
	@NotBlank
	private String pag_observacion;
	
	@NotBlank
	private BigDecimal pag_monto;
	
	@NotBlank
	private String pag_registrado_por;
	
	@NotBlank
	private LocalDate pag_fecha_registro;
}

