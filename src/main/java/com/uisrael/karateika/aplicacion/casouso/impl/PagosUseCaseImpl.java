package com.uisrael.karateika.aplicacion.casouso.impl;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.aplicacion.casouso.entradas.IPagosUseCase;
import com.uisrael.karateika.dominio.entidades.Pagos;
import com.uisrael.karateika.dominio.repositorios.IPagosRepositorio;

public class PagosUseCaseImpl implements IPagosUseCase{

	private final IPagosRepositorio repositorio;
	
	
	public PagosUseCaseImpl(IPagosRepositorio repositorio) {
		
		this.repositorio = repositorio;
	}

	@Override
	public Pagos guardar(Pagos pagos) {
		 return repositorio.guardar(pagos);
	}

	@Override
	public Optional<Pagos> buscarPorId(int id) {
		 return repositorio.buscarPorId(id);
	}

	@Override
	public List<Pagos> listarTodos() {
		 return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}

}
