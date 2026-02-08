package com.uisrael.karateika.presentacion.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PagosRequestDTO {

	
	private Integer pag_id;

	@NotNull(message = "La fecha de pago es obligatoria")
	@PastOrPresent(message = "La fecha de pago no puede ser futura")
	private LocalDate pag_fecha_pago;

	@NotBlank(message = "El método de pago es obligatorio")
	@Pattern(regexp = "^(Efectivo|Transferencia Bancaria|Tarjeta de Crédito|Tarjeta de Débito|Otro)$", message = "Método de pago no válido")
	private String pag_metodo_pago;

	@Size(max = 50, message = "El número de recibo no puede exceder 50 caracteres")
	private String pag_numero_recibo;

	@Size(max = 255, message = "La observación no puede exceder 255 caracteres")
	private String pag_observacion;

	@NotNull(message = "El monto es obligatorio")
	@DecimalMin(value = "0.01", message = "El monto debe ser mayor a 0")
	private BigDecimal pag_monto;

	@NotBlank(message = "El nombre de quien registra es obligatorio")
	@Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
	private String pag_registrado_por;

	@NotNull(message = "La fecha de registro es obligatoria")
	@PastOrPresent(message = "La fecha de registro no puede ser futura")
	private LocalDate pag_fecha_registro;

	@NotNull(message = "El alumno es obligatorio")
	private AlumnoRequestDTO fkalumno;

	@NotNull(message = "El comprobante es obligatorio")
	private ComprobanteRequestDTO fkcomprobante;
}
