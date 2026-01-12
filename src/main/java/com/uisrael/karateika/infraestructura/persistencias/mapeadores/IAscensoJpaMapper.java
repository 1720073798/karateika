package com.uisrael.karateika.infraestructura.persistencias.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.karateika.dominio.entidades.Ascenso;
import com.uisrael.karateika.infraestructura.persistencias.jpa.AscensoJpa;

@Mapper(componentModel = "spring")
public interface IAscensoJpaMapper {

    Ascenso toDomain(AscensoJpa entity);

    AscensoJpa toEntity(Ascenso ascenso);
}
