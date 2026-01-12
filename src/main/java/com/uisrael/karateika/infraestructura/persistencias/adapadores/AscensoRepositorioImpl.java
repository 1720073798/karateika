package com.uisrael.karateika.infraestructura.persistencias.adapadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.karateika.dominio.entidades.Ascenso;
import com.uisrael.karateika.dominio.repositorios.IAscensoRepositorio;
import com.uisrael.karateika.infraestructura.persistencias.jpa.AscensoJpa;
import com.uisrael.karateika.infraestructura.persistencias.mapeadores.IAscensoJpaMapper;
import com.uisrael.karateika.infraestructura.repositorios.IAscensoJpaRepositorio;

public class AscensoRepositorioImpl implements IAscensoRepositorio {

    private final IAscensoJpaRepositorio jpaRepository;
    private final IAscensoJpaMapper entityMapper;

    public AscensoRepositorioImpl(IAscensoJpaRepositorio jpaRepository,
                                  IAscensoJpaMapper entityMapper) {

        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Ascenso guardar(Ascenso ascenso) {
        AscensoJpa entity = entityMapper.toEntity(ascenso);
        AscensoJpa guardado = jpaRepository.save(entity); // insert o update
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<Ascenso> buscarPorId(int id) {
        return jpaRepository.findById(id).map(entityMapper::toDomain);
    }

    @Override
    public List<Ascenso> listarTodos() {
        return jpaRepository.findAll()
                .stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    @Override
    public void eliminar(int id) {
        jpaRepository.deleteById(id);
    }
}
