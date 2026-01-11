package com.uisrael.karateika.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.karateika.aplicacion.casouso.entradas.IComprobanteUseCase;
import com.uisrael.karateika.presentacion.dto.request.ComprobanteRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.ComprobanteResponseDTO;
import com.uisrael.karateika.presentacion.mapeadores.IComprobanteDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comprobantes")
public class ComprobanteControlador {

	private final IComprobanteUseCase comprobanteUseCase;
    private final IComprobanteDtoMapper mapper;

    public ComprobanteControlador(IComprobanteUseCase comprobanteUseCase, IComprobanteDtoMapper mapper) {
		this.comprobanteUseCase = comprobanteUseCase;
		this.mapper = mapper;
	}

	@GetMapping
    public List<ComprobanteResponseDTO> listar() {
        return comprobanteUseCase.listarTodos()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComprobanteResponseDTO crear(@Valid @RequestBody ComprobanteRequestDTO request) {
        return mapper.toResponseDto(
                comprobanteUseCase.guardar(
                        mapper.toDomain(request)
                )
        );
    }
}
