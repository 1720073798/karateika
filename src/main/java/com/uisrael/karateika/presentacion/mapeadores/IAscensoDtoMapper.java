package com.uisrael.karateika.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.karateika.dominio.entidades.Ascenso;
import com.uisrael.karateika.presentacion.dto.request.AscensoRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.AscensoResponseDTO;

@Mapper(componentModel = "spring")
public interface IAscensoDtoMapper {

    Ascenso toDomain(AscensoRequestDTO dto);

    AscensoResponseDTO toResponseDto(Ascenso ascenso);
}
