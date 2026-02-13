package com.uisrael.karateika.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.karateika.dominio.entidades.Comprobante;
import com.uisrael.karateika.presentacion.dto.request.ComprobanteRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.ComprobanteResponseDTO;

@Mapper(componentModel = "spring")
public interface IComprobanteDtoMapper {

    @Mapping(target = "com_id", expression = "java(dto.getCom_id() == null ? 0 : dto.getCom_id())")
    @Mapping(target = "com_numero", expression = "java(dto.getCom_numero() == null ? 0 : dto.getCom_numero())")
    Comprobante toDomain(ComprobanteRequestDTO dto);

    ComprobanteResponseDTO toResponseDto(Comprobante comprobante);
}