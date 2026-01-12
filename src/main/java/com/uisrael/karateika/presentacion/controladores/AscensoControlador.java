package com.uisrael.karateika.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.karateika.aplicacion.casouso.entradas.IAscensoUseCase;
import com.uisrael.karateika.presentacion.dto.request.AscensoRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.AscensoResponseDTO;
import com.uisrael.karateika.presentacion.mapeadores.IAscensoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ascensos")
public class AscensoControlador {

    private final IAscensoUseCase ascensoUseCase;
    private final IAscensoDtoMapper mapper;

    public AscensoControlador(IAscensoUseCase ascensoUseCase, IAscensoDtoMapper mapper) {
        this.ascensoUseCase = ascensoUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<AscensoResponseDTO> listar() {
        return ascensoUseCase.listarTodos()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AscensoResponseDTO crear(@Valid @RequestBody AscensoRequestDTO request) {
        return mapper.toResponseDto(
                ascensoUseCase.guardar(
                        mapper.toDomain(request)
                )
        );
    }
}
