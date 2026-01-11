package com.uisrael.karateika.aplicacion.casouso.impl;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.aplicacion.casouso.entradas.IComprobanteUseCase;
import com.uisrael.karateika.dominio.entidades.Comprobante;
import com.uisrael.karateika.dominio.repositorios.IComprobanteRepositorio;

public class ComprobanteUseCaseImpl implements IComprobanteUseCase{

	private final IComprobanteRepositorio repositorio;
	
	
	public ComprobanteUseCaseImpl(IComprobanteRepositorio repositorio) {
		
		this.repositorio = repositorio;
	}

	@Override
	public Comprobante guardar(Comprobante comprobante) {
		return repositorio.guardar(comprobante);
	}

	@Override
	public Optional<Comprobante> buscarPorId(int id) {
		 return repositorio.buscarPorId(id);
	}

	@Override
	public List<Comprobante> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
