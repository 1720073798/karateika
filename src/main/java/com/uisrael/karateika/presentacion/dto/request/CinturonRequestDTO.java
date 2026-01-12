package com.uisrael.karateika.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CinturonRequestDTO {
	
	@NotBlank
	private int cin_id;
	@NotBlank
	private String cin_nombre;
	@NotBlank
	private String cin_nivel;
	@NotBlank
	private String cin_descripcion;
}
