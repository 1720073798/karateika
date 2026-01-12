package com.uisrael.karateika.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Ascenso;

public interface IAscensoRepositorio {

    Ascenso guardar(Ascenso ascenso);

    Optional<Ascenso> buscarPorId(int id);

    List<Ascenso> listarTodos();

    void eliminar(int id);
}
