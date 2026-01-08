package com.uisrael.karateika.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;


import com.uisrael.karateika.infraestructura.persistencias.jpa.AsistenciaJpa;

public interface IAsistenciaRepositorio extends JpaRepository<AsistenciaJpa, Integer> {

}
