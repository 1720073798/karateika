package com.uisrael.karateika.aplicacion.casouso.impl;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.aplicacion.casouso.entradas.IAscensoUseCase;
import com.uisrael.karateika.dominio.entidades.Ascenso;
import com.uisrael.karateika.dominio.repositorios.IAscensoRepositorio;

public class AscensoUseCaseImpl implements IAscensoUseCase {

    private final IAscensoRepositorio repositorio;

    public AscensoUseCaseImpl(IAscensoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Ascenso guardar(Ascenso ascenso) {
        return repositorio.guardar(ascenso);
    }

    @Override
    public Optional<Ascenso> buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    @Override
    public List<Ascenso> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }
}
