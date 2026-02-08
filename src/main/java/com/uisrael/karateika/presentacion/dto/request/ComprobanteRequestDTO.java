package com.uisrael.karateika.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ComprobanteRequestDTO {

	private Integer com_id;

	@NotNull(message = "El número de comprobante es obligatorio")
	@Min(value = 1, message = "El número de comprobante debe ser mayor a 0")
	private Integer com_numero; 

	private String com_ruta_archivo;

	@NotNull(message = "La fecha de subida es obligatoria")
	private LocalDate com_fecha_subida;
}
