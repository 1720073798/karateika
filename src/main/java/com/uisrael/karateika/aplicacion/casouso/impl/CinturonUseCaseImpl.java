package com.uisrael.karateika.aplicacion.casouso.impl;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.aplicacion.casouso.entradas.ICinturonUseCase;
import com.uisrael.karateika.dominio.entidades.Cinturon;
import com.uisrael.karateika.dominio.repositorios.ICinturonRepositorio;

public class CinturonUseCaseImpl implements ICinturonUseCase {
	
	private final ICinturonRepositorio cinturonRepositorio;
	
	public CinturonUseCaseImpl(ICinturonRepositorio cinturonRepositorio) {
		this.cinturonRepositorio = cinturonRepositorio;
	}

	@Override
	public Cinturon guardar(Cinturon cinturon) {
		return cinturonRepositorio.guardar(cinturon);
	}

	@Override
	public Optional<Cinturon> buscarPorId(int id) {
		return cinturonRepositorio.buscarPorId(id);
	}

	@Override
	public List<Cinturon> listarTodos() {
		return cinturonRepositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		cinturonRepositorio.eliminar(id);
	}
}
