package com.uisrael.karateika.infraestructura.persistencias.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.karateika.dominio.entidades.Pagos;
import com.uisrael.karateika.infraestructura.persistencias.jpa.PagosJpa;

@Mapper(componentModel = "spring")
public interface IPagosJpaMapper {

	Pagos toDomain(PagosJpa entity);

	
    PagosJpa toEntity(Pagos pagos);
}
