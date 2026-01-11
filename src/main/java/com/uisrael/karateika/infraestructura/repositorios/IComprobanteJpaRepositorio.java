package com.uisrael.karateika.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.karateika.infraestructura.persistencias.jpa.ComprobanteJpa;

public interface IComprobanteJpaRepositorio extends JpaRepository<ComprobanteJpa, Integer>{

}
