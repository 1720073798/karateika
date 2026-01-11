package com.uisrael.karateika.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Comprobante;

public interface IComprobanteRepositorio {

	 Comprobante guardar(Comprobante comprobante);

	    Optional<Comprobante> buscarPorId(int id);

	    List<Comprobante> listarTodos();

	    void eliminar(int id);
}
