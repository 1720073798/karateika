package com.uisrael.karateika.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.karateika.dominio.entidades.Pagos;
import com.uisrael.karateika.infraestructura.persistencias.jpa.ComprobanteJpa;
import com.uisrael.karateika.presentacion.dto.request.PagosRequestDTO;
import com.uisrael.karateika.presentacion.dto.request.ComprobanteRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.PagosResponseDTO;

@Mapper(componentModel = "spring")
public interface IPagosDtoMapper {

	 Pagos toDomain(PagosRequestDTO dto);

	 PagosResponseDTO toResponseDto(Pagos pagos);

	 @Mapping(target = "com_id", expression = "java(dto.getCom_id() == null ? 0 : dto.getCom_id())")
	 @Mapping(target = "com_numero", expression = "java(dto.getCom_numero() == null ? 0 : dto.getCom_numero())")
	 ComprobanteJpa comprobanteRequestDTOToComprobanteJpa(ComprobanteRequestDTO dto);
	 
}