package com.uisrael.karateika.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.karateika.infraestructura.persistencias.jpa.PagosJpa;

public interface IPagosRepositorio extends JpaRepository<PagosJpa, Integer> {

}
