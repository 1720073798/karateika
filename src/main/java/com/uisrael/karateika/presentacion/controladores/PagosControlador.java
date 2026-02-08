package com.uisrael.karateika.presentacion.controladores;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.karateika.aplicacion.casouso.entradas.IPagosUseCase;
import com.uisrael.karateika.presentacion.dto.request.PagosRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.PagosResponseDTO;
import com.uisrael.karateika.presentacion.mapeadores.IPagosDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pagos")
public class PagosControlador {

	private static final Logger logger = LoggerFactory.getLogger(PagosControlador.class);
	private final IPagosUseCase pagosUseCase;
	private final IPagosDtoMapper mapper;

	public PagosControlador(IPagosUseCase pagosUseCase, IPagosDtoMapper mapper) {
		this.pagosUseCase = pagosUseCase;
		this.mapper = mapper;
	}

	@GetMapping
	public List<PagosResponseDTO> listar() {
		return pagosUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/buscarid/{id}")
	public PagosResponseDTO buscarPorId(@PathVariable int id) {
		Optional<com.uisrael.karateika.dominio.entidades.Pagos> pagoOpt = pagosUseCase.buscarPorId(id);

		if (pagoOpt.isPresent()) {
			return mapper.toResponseDto(pagoOpt.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pago no encontrado");
		}
	}

	@GetMapping("/buscar")
	public List<PagosResponseDTO> buscar(@RequestParam(required = false) String comprobante,
			@RequestParam(required = false) String alumno, @RequestParam(required = false) String fecha) {

		var todos = pagosUseCase.listarTodos().stream().map(mapper::toResponseDto);

		if (comprobante != null && !comprobante.isEmpty()) {
			todos = todos.filter(p -> p.getFkcomprobante() != null
					&& String.valueOf(p.getFkcomprobante().getCom_numero()).contains(comprobante));
		}

		if (alumno != null && !alumno.isEmpty()) {
			todos = todos.filter(p -> p.getFkalumno() != null
					&& (p.getFkalumno().getAlu_nombre().toLowerCase().contains(alumno.toLowerCase())
							|| p.getFkalumno().getAlu_apellido().toLowerCase().contains(alumno.toLowerCase())));
		}

		if (fecha != null && !fecha.isEmpty()) {
			todos = todos.filter(p -> p.getPag_fecha_pago().toString().contains(fecha));
		}

		return todos.toList();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public PagosResponseDTO crear(@Valid @RequestBody PagosRequestDTO request) {
		// Validar que la fecha de registro no sea anterior a la fecha de pago
		if (request.getPag_fecha_registro().isBefore(request.getPag_fecha_pago())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"La fecha de registro no puede ser anterior a la fecha de pago");
		}

		return mapper.toResponseDto(pagosUseCase.guardar(mapper.toDomain(request)));
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		logger.warn("ELIMINACIÓN - Pago ID: {}", id);
		pagosUseCase.eliminar(id);
	}
}
