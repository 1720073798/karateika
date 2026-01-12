package com.uisrael.karateika.infraestructura.persistencias.adapadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Alumno;
import com.uisrael.karateika.dominio.repositorios.IAlumnoRepositorio;
import com.uisrael.karateika.infraestructura.persistencias.jpa.AlumnoJpa;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.IAlumnoJpaMapper;
import com.uisrael.karateika.infraestructura.repositorios.IAlumnoJpaRepositorio;

public class AlumnoRepositorioImpl implements IAlumnoRepositorio {
	
	private final IAlumnoJpaRepositorio alumnoJpaRepository;
	private final IAlumnoJpaMapper alumnoJpaMapper;	

	public AlumnoRepositorioImpl(IAlumnoJpaRepositorio alumnoJpaRepository, IAlumnoJpaMapper alumnoJpaMapper) {
		this.alumnoJpaRepository = alumnoJpaRepository;
		this.alumnoJpaMapper = alumnoJpaMapper;
	}

	@Override
	public Alumno guardar(Alumno alumno) {
		AlumnoJpa alumnoJpa = alumnoJpaMapper.toEntity(alumno);
		AlumnoJpa guardado = alumnoJpaRepository.save(alumnoJpa);
		return alumnoJpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Alumno> buscarPorId(int id) {
		return alumnoJpaRepository.findById(id).map(alumnoJpaMapper::toDomain);
	}

	@Override
	public List<Alumno> listarTodos() {
		return alumnoJpaRepository.findAll().stream()
				.map(alumnoJpaMapper::toDomain)
				.toList();
	}

	@Override
	public void eliminar(int id) {
		alumnoJpaRepository.deleteById(id);
	}

}
