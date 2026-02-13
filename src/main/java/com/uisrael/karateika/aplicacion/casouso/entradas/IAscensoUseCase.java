package com.uisrael.karateika.aplicacion.casouso.entradas;

import java.util.List;

import com.uisrael.karateika.dominio.entidades.Ascenso;

public interface IAscensoUseCase {

    Ascenso guardar(Ascenso ascenso);

    Ascenso obtenerPorId(int id);

    List<Ascenso> listarTodos();

    void eliminar(int id);
}

