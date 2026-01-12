package com.uisrael.karateika.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.karateika.dominio.entidades.Cinturon;
import com.uisrael.karateika.presentacion.dto.request.CinturonRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.CinturonResposneDTO;

@Mapper(componentModel = "spring")
public interface ICinturonDtoMapper {
	
	Cinturon toDomain(CinturonRequestDTO dto);
	
	CinturonResposneDTO toResponseDto(Cinturon cinturon);

}
