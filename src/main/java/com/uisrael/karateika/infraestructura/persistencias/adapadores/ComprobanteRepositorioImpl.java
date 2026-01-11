package com.uisrael.karateika.infraestructura.persistencias.adapadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Comprobante;
import com.uisrael.karateika.dominio.repositorios.IComprobanteRepositorio;
import com.uisrael.karateika.infraestructura.persistencias.jpa.ComprobanteJpa;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.IComprobanteJpaMapper;
import com.uisrael.karateika.infraestructura.repositorios.IComprobanteJpaRepositorio;

public class ComprobanteRepositorioImpl implements IComprobanteRepositorio{

	private final IComprobanteJpaRepositorio jpaRepository;
    private final IComprobanteJpaMapper entityMapper;
    
    
	public ComprobanteRepositorioImpl(IComprobanteJpaRepositorio jpaRepository, IComprobanteJpaMapper entityMapper) {
		
		this.jpaRepository = jpaRepository;
		this.entityMapper = entityMapper;
	}

	@Override
	public Comprobante guardar(Comprobante comprobante) {
		ComprobanteJpa entity = entityMapper.toEntity(comprobante);
        ComprobanteJpa guardado = jpaRepository.save(entity); // insert o update
        return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Comprobante> buscarPorId(int id) {
		return jpaRepository.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Comprobante> listarTodos() {
		 return jpaRepository.findAll().stream()
	                .map(entityMapper::toDomain)
	                .toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepository.deleteById(id);
	}

}
