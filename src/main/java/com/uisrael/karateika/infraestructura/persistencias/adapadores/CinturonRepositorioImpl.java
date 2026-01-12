package com.uisrael.karateika.infraestructura.persistencias.adapadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Cinturon;
import com.uisrael.karateika.dominio.repositorios.ICinturonRepositorio;
import com.uisrael.karateika.infraestructura.persistencias.jpa.CinturonJpa;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.ICinturonJpaMapper;
import com.uisrael.karateika.infraestructura.repositorios.ICinturonJpaRepositorio;

public class CinturonRepositorioImpl implements ICinturonRepositorio {
	private final ICinturonJpaMapper cinturonJpaMapper;
	private final ICinturonJpaRepositorio cinturonJpaRepositorio;

	public CinturonRepositorioImpl(ICinturonJpaRepositorio cinturonJpaRepositorio, ICinturonJpaMapper cinturonJpaMapper) {
		this.cinturonJpaMapper = cinturonJpaMapper;
		this.cinturonJpaRepositorio = cinturonJpaRepositorio;
	}

	@Override
	public Cinturon guardar(Cinturon cinturon) {
		CinturonJpa entity = cinturonJpaMapper.toEntity(cinturon);
		CinturonJpa guardado = cinturonJpaRepositorio.save(entity);
		return cinturonJpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Cinturon> buscarPorId(int id) {
		return cinturonJpaRepositorio.findById(id)
				.map(cinturonJpaMapper::toDomain);
	}

	@Override
	public List<Cinturon> listarTodos() {
		return cinturonJpaRepositorio.findAll().stream()
				.map(cinturonJpaMapper::toDomain)
				.toList();
	}

	@Override
	public void eliminar(int id) {
		cinturonJpaRepositorio.deleteById(id);
	}

}
