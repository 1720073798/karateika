package com.uisrael.karateika.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ComprobanteRequestDTO {

	@NotBlank
	 private int com_id;
	@NotBlank
	 private String com_nombre;
	@NotBlank
	 private String com_ruta_archivo;
	@NotBlank
	 private LocalDate com_fecha_subida;

	 
}

