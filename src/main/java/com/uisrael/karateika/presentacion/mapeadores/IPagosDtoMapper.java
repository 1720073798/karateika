package com.uisrael.karateika.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.karateika.dominio.entidades.Pagos;
import com.uisrael.karateika.presentacion.dto.request.PagosRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.PagosResponseDTO;

@Mapper(componentModel = "spring")
public interface IPagosDtoMapper {

	 Pagos toDomain(PagosRequestDTO dto);

	 PagosResponseDTO toResponseDto(Pagos pagos);
	 
}
