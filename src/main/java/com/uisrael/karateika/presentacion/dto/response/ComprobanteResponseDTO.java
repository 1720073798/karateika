package com.uisrael.karateika.presentacion.dto.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ComprobanteResponseDTO {

	private int com_id;
    private int com_numero;  // ✅ int
    private String com_ruta_archivo;
    private LocalDate com_fecha_subida;
    
	
}
