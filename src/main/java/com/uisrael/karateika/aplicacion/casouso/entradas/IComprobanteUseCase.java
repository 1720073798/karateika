package com.uisrael.karateika.aplicacion.casouso.entradas;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Comprobante;

public interface IComprobanteUseCase {

	Comprobante guardar(Comprobante comprobante);

    Optional<Comprobante> buscarPorId(int id);

    List<Comprobante> listarTodos();

    void eliminar(int id);
}
