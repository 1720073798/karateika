package com.uisrael.karateika.infraestructura.persistencias.adapadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Asistencia;
import com.uisrael.karateika.dominio.repositorios.IAsistenciaRepositorio;
import com.uisrael.karateika.infraestructura.persistencias.jpa.AsistenciaJpa;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.IAsistenciaJpaMapper;
import com.uisrael.karateika.infraestructura.repositorios.IAsistenciaJpaRepositorio;
import com.uisrael.karateika.infraestructura.repositorios.IAlumnoJpaRepositorio;
import com.uisrael.karateika.infraestructura.persistencias.jpa.AlumnoJpa;

public class AsistenciaRepositorioImpl implements IAsistenciaRepositorio {
	
	private final IAsistenciaJpaRepositorio asistenciaJpaRepository;
	private final IAsistenciaJpaMapper entityMapper; 
	private final IAlumnoJpaRepositorio alumnoJpaRepository;

	public AsistenciaRepositorioImpl(IAsistenciaJpaRepositorio asistenciaJpaRepository,
			IAsistenciaJpaMapper entityMapper) {
		this.asistenciaJpaRepository = asistenciaJpaRepository;
		this.entityMapper = entityMapper;
		this.alumnoJpaRepository = null;
	}
	
	// Nuevo constructor que recibe el repositorio de AlumnoJpa para obtener referencias
	public AsistenciaRepositorioImpl(IAsistenciaJpaRepositorio asistenciaJpaRepository,
			IAsistenciaJpaMapper entityMapper, IAlumnoJpaRepositorio alumnoJpaRepository) {
		this.asistenciaJpaRepository = asistenciaJpaRepository;
		this.entityMapper = entityMapper;
		this.alumnoJpaRepository = alumnoJpaRepository;
	}

	@Override
	public Asistencia guardar(Asistencia asistencia) {
		AsistenciaJpa entity = entityMapper.toEntity(asistencia);
		// Si viene referenciado solo el id del alumno, recuperar una referencia administrada
		if (entity.getFkalumno() != null && entity.getFkalumno().getAlu_id() != 0 && alumnoJpaRepository != null) {
			int aluId = entity.getFkalumno().getAlu_id();
			AlumnoJpa ref = alumnoJpaRepository.getReferenceById(aluId);
			entity.setFkalumno(ref);
		}
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

	@Override
	public List<Asistencia> guardarTodos(List<Asistencia> asistencias) {
		List<Asistencia> resultado = new ArrayList<>();
		for (Asistencia a : asistencias) {
			AsistenciaJpa entity = entityMapper.toEntity(a);
			if (entity.getFkalumno() != null && entity.getFkalumno().getAlu_id() != 0 && alumnoJpaRepository != null) {
				int aluId = entity.getFkalumno().getAlu_id();
				AlumnoJpa ref = alumnoJpaRepository.getReferenceById(aluId);
				entity.setFkalumno(ref);
			}
			AsistenciaJpa guardado = asistenciaJpaRepository.save(entity);
			resultado.add(entityMapper.toDomain(guardado));
		}
		return resultado;
	}

}