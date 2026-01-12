package com.uisrael.karateika.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.karateika.dominio.entidades.Alumno;
import com.uisrael.karateika.presentacion.dto.request.AlumnoRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.AlumnoResponseDTO;

@Mapper(componentModel = "spring")
public interface IAlumnoDtoMapper {
	
	Alumno toDomain(AlumnoRequestDTO dto);
	
	AlumnoResponseDTO toResponseDto(Alumno alumno);

}
