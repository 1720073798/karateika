package com.uisrael.karateika.infraestructura.persistencias.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.karateika.dominio.entidades.Alumno;
import com.uisrael.karateika.infraestructura.persistencias.jpa.AlumnoJpa;

@Mapper(componentModel = "spring")
public interface IAlumnoJpaMapper {
	
	Alumno toDomain(AlumnoJpa entity);
	
	AlumnoJpa toEntity(Alumno alumno);

}
