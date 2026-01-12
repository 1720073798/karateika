package com.uisrael.karateika.aplicacion.casouso.impl;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.aplicacion.casouso.entradas.IAsistenciaUseCase;
import com.uisrael.karateika.dominio.entidades.Asistencia;
import com.uisrael.karateika.dominio.repositorios.IAsistenciaRepositorio;

public class AsistenciaUseCaseImpl implements IAsistenciaUseCase {
	
	private final IAsistenciaRepositorio repositorio;

	public AsistenciaUseCaseImpl(IAsistenciaRepositorio repositorio) {
		
		this.repositorio = repositorio;
	}

	@Override
	public Asistencia guardar(Asistencia asistencia) {
		
		return repositorio.guardar(asistencia);
	}

	@Override
	public Optional<Asistencia> buscarPorId(int id) {
		return repositorio.buscarPorId(id);
	}

	@Override
	public List<Asistencia> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);		
	}
}
