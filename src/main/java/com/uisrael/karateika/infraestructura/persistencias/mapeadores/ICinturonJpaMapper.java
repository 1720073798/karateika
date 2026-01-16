package com.uisrael.karateika.infraestructura.persistencias.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.karateika.dominio.entidades.Cinturon;
import com.uisrael.karateika.infraestructura.persistencias.jpa.CinturonJpa;

@Mapper(componentModel = "spring")
public interface ICinturonJpaMapper {
	
	Cinturon toDomain(CinturonJpa cinturonJpa);
	
	CinturonJpa toEntity(Cinturon cinturon);
}
