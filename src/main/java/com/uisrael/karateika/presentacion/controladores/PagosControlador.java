package com.uisrael.karateika.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.karateika.aplicacion.casouso.entradas.IPagosUseCase;
import com.uisrael.karateika.presentacion.dto.request.PagosRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.PagosResponseDTO;
import com.uisrael.karateika.presentacion.mapeadores.IPagosDtoMapper;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/pagos")
public class PagosControlador {

	 private final IPagosUseCase pagosUseCase;
	    private final IPagosDtoMapper mapper;

	    public PagosControlador(IPagosUseCase pagosUseCase, IPagosDtoMapper mapper) {
			
			this.pagosUseCase = pagosUseCase;
			this.mapper = mapper;
		}

		@GetMapping
	    public List<PagosResponseDTO> listar() {
	        return pagosUseCase.listarTodos()
	                .stream()
	                .map(mapper::toResponseDto)
	                .toList();
	    }

	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public PagosResponseDTO crear(@Valid @RequestBody PagosRequestDTO request) {
	        return mapper.toResponseDto(
	                pagosUseCase.guardar(
	                        mapper.toDomain(request)
	                )
	        );
	    }
}
