package com.uisrael.karateika.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.karateika.aplicacion.casouso.entradas.IAsistenciaUseCase;
import com.uisrael.karateika.presentacion.dto.request.AsistenciaRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.AsistenciaResponseDTO;
import com.uisrael.karateika.presentacion.mapeadores.IAsistenciaDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaControlador {

    private final IAsistenciaUseCase asistenciaUseCase;
    private final IAsistenciaDtoMapper mapper;

    public AsistenciaControlador(IAsistenciaUseCase asistenciaUseCase, IAsistenciaDtoMapper mapper) {
        this.asistenciaUseCase = asistenciaUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<AsistenciaResponseDTO> listar() {
        return asistenciaUseCase.listarTodos()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AsistenciaResponseDTO crear(@Valid @RequestBody AsistenciaRequestDTO request) {
        return mapper.toResponseDto(
                asistenciaUseCase.guardar(
                        mapper.toDomain(request)
                )
        );
    }
}