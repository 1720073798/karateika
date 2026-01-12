package com.uisrael.karateika.aplicacion.casouso.entradas;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Alumno;

public interface IAlumnoUseCase {
	
	Alumno guardar(Alumno alumno);
	
	Optional<Alumno> buscarPorId(int id);
	
	List<Alumno> listarTodos();
	
	void eliminar(int id);

}
