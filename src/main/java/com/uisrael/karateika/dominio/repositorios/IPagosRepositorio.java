package com.uisrael.karateika.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Pagos;

public interface IPagosRepositorio {

	 Pagos guardar(Pagos pago);

	    Optional<Pagos> buscarPorId(int id);

	    List<Pagos> listarTodos();

	    void eliminar(int id);
}
