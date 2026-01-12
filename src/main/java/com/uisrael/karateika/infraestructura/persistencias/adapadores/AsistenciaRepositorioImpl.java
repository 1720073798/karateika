package com.uisrael.karateika.infraestructura.persistencias.adapadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Asistencia;
import com.uisrael.karateika.dominio.repositorios.IAsistenciaRepositorio;
import com.uisrael.karateika.infraestructura.persistencias.jpa.AsistenciaJpa;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.IAsistenciaJpaMapper;
import com.uisrael.karateika.infraestructura.repositorios.IAsistenciaJpaRepositorio;

public class AsistenciaRepositorioImpl implements IAsistenciaRepositorio {
	
	private final IAsistenciaJpaRepositorio asistenciaJpaRepository;
	private final IAsistenciaJpaMapper entityMapper;	

	public AsistenciaRepositorioImpl(IAsistenciaJpaRepositorio asistenciaJpaRepository,
			IAsistenciaJpaMapper entityMapper) {
		this.asistenciaJpaRepository = asistenciaJpaRepository;
		this.entityMapper = entityMapper;
	}

	@Override
	public Asistencia guardar(Asistencia asistencia) {
		AsistenciaJpa entity = entityMapper.toEntity(asistencia);
		AsistenciaJpa guardado = asistenciaJpaRepository.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Asistencia> buscarPorId(int id) {
		return asistenciaJpaRepository.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Asistencia> listarTodos() {
		return asistenciaJpaRepository.findAll().stream()
				.map(entityMapper::toDomain)
				.toList();
		}

	@Override
	public void eliminar(int id) {
		asistenciaJpaRepository.deleteById(id);
	}

}
