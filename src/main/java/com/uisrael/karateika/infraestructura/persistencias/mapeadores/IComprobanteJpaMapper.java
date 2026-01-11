package com.uisrael.karateika.infraestructura.persistencias.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.karateika.dominio.entidades.Comprobante;
import com.uisrael.karateika.infraestructura.persistencias.jpa.ComprobanteJpa;

@Mapper(componentModel = "spring")
public interface IComprobanteJpaMapper {

	 Comprobante toDomain(ComprobanteJpa entity);

	    ComprobanteJpa toEntity(Comprobante comprobante);
}
