package com.uisrael.karateika.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.karateika.infraestructura.persistencias.jpa.CinturonJpa;

public interface ICinturonRepositorio extends JpaRepository<CinturonJpa, Integer> {

}
