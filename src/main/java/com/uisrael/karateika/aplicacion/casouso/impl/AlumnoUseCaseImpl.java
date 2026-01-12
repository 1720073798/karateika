package com.uisrael.karateika.aplicacion.casouso.impl;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.aplicacion.casouso.entradas.IAlumnoUseCase;
import com.uisrael.karateika.dominio.entidades.Alumno;
import com.uisrael.karateika.dominio.repositorios.IAlumnoRepositorio;

public class AlumnoUseCaseImpl implements IAlumnoUseCase {
	
	private final IAlumnoRepositorio alumnoRepository;
	
	public AlumnoUseCaseImpl(IAlumnoRepositorio alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}

	@Override
	public Alumno guardar(Alumno alumno) {
		return alumnoRepository.guardar(alumno);
	}

	@Override
	public Optional<Alumno> buscarPorId(int id) {
		return alumnoRepository.buscarPorId(id);
	}

	@Override
	public List<Alumno> listarTodos() {
		return alumnoRepository.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		alumnoRepository.eliminar(id);
	}
}
