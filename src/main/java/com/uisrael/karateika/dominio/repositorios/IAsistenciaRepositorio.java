package com.uisrael.karateika.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Asistencia;

public interface IAsistenciaRepositorio {
	
	Asistencia guardar(Asistencia asistencia);
	
	Optional<Asistencia> buscarPorId(int id);
	
	List<Asistencia> listarTodos();
	
	void eliminar(int id);
	

}
