package com.uisrael.karateika.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Alumno;

public interface IAlumnoRepositorio {
	Alumno guardar(Alumno alumno);
	
	Optional<Alumno> buscarPorId(int id);
	
	List<Alumno> listarTodos();
	
	void eliminar(int id);

}
