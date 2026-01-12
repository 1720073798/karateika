package com.uisrael.karateika.aplicacion.casouso.entradas;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Ascenso;

public interface IAscensoUseCase {

    Ascenso guardar(Ascenso ascenso);

    Optional<Ascenso> buscarPorId(int id);

    List<Ascenso> listarTodos();

    void eliminar(int id);
}

