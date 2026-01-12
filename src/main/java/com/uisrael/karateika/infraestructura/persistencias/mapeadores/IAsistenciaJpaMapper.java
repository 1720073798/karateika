package com.uisrael.karateika.infraestructura.persistencias.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.karateika.dominio.entidades.Asistencia;
import com.uisrael.karateika.infraestructura.persistencias.jpa.AsistenciaJpa;

@Mapper(componentModel = "spring")
public interface IAsistenciaJpaMapper {
	
	Asistencia toDomain(AsistenciaJpa entity);
	
	AsistenciaJpa toEntity(Asistencia asistencia);
}
