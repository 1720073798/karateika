package com.uisrael.karateika.aplicacion.casouso.entradas;

import java.util.List;


import com.uisrael.karateika.dominio.entidades.Alumno;

public interface IAlumnoUseCase {
	
	Alumno guardar(Alumno alumno);
	
	Alumno obtenerPorId(int id);//para editar
	
	List<Alumno> listarTodos();
	
	void eliminar(int id);
	
	public List<Alumno> findByNombre(String nombre);

}
