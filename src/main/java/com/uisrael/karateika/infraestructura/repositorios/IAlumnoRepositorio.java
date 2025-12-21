package com.uisrael.karateika.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.karateika.infraestructura.persistencias.jpa.AlumnoJpa;

public interface IAlumnoRepositorio extends JpaRepository<AlumnoJpa, Integer> {

}
