package com.uisrael.karateika.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Cinturon;

public interface ICinturonRepositorio {
	
	Cinturon guardar(Cinturon cinturon);
	
	Optional<Cinturon> buscarPorId(int id);
	
	List<Cinturon> listarTodos();
	
	void eliminar(int id);	

}
