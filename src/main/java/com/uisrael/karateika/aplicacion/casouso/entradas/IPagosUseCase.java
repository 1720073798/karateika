package com.uisrael.karateika.aplicacion.casouso.entradas;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Pagos;

public interface IPagosUseCase {

	Pagos guardar(Pagos pagos);

    Optional<Pagos> buscarPorId(int id);

    List<Pagos> listarTodos();

    void eliminar(int id);
}
