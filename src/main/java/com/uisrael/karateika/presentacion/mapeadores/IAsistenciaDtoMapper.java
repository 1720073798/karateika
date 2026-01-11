package com.uisrael.karateika.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.karateika.dominio.entidades.Asistencia;
import com.uisrael.karateika.presentacion.dto.request.AsistenciaRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.AsistenciaResponseDTO;

@Mapper(componentModel = "spring")
public interface IAsistenciaDtoMapper {

    Asistencia toDomain(AsistenciaRequestDTO dto);

    AsistenciaResponseDTO toResponseDto(Asistencia asistencia);
}
