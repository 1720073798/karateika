package com.uisrael.karateika.infraestructura.persistencias.adapadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Pagos;
import com.uisrael.karateika.dominio.repositorios.IPagosRepositorio;
import com.uisrael.karateika.infraestructura.persistencias.jpa.PagosJpa;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.IPagosJpaMapper;
import com.uisrael.karateika.infraestructura.repositorios.IPagosJpaRepositorio;

public class PagosRepositorioImpl implements IPagosRepositorio{

	private final IPagosJpaRepositorio jpaRepository;
    private final IPagosJpaMapper entityMapper;
    
    
	public PagosRepositorioImpl(IPagosJpaRepositorio jpaRepository, IPagosJpaMapper entityMapper) {
		
		this.jpaRepository = jpaRepository;
		this.entityMapper = entityMapper;
	}

	@Override
	public Pagos guardar(Pagos pago) {
		 PagosJpa entity = entityMapper.toEntity(pago);
	     PagosJpa guardado = jpaRepository.save(entity); // insert o update
	     return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Pagos> buscarPorId(int id) {
		return jpaRepository.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Pagos> listarTodos() {
		 return jpaRepository.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepository.deleteById(id);
	}

}
