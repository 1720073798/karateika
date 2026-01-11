package com.uisrael.karateika.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.karateika.dominio.entidades.Comprobante;
import com.uisrael.karateika.presentacion.dto.request.ComprobanteRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.ComprobanteResponseDTO;

@Mapper(componentModel = "spring")
public interface IComprobanteDtoMapper {

	Comprobante toDomain(ComprobanteRequestDTO dto);

    ComprobanteResponseDTO toResponseDto(Comprobante comprobante);
}
