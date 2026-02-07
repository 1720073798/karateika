package com.uisrael.karateika.presentacion.controladores;

import java.util.List;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.karateika.aplicacion.casouso.entradas.IAlumnoUseCase;
import com.uisrael.karateika.presentacion.dto.request.AlumnoRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.AlumnoResponseDTO;
import com.uisrael.karateika.presentacion.mapeadores.IAlumnoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoControlador {
	
	private final IAlumnoUseCase alumnoUseCase;
	private final IAlumnoDtoMapper alumnoDTOMapper;
	
	public AlumnoControlador(IAlumnoUseCase alumnoUseCase, IAlumnoDtoMapper alumnoDTOMapper) {
		this.alumnoUseCase = alumnoUseCase;
		this.alumnoDTOMapper = alumnoDTOMapper;
	}
	
	@GetMapping
	public List<AlumnoResponseDTO> listar(){
		return alumnoUseCase.listarTodos().stream()
				.map(alumnoDTOMapper::toResponseDto)
				.toList();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public AlumnoResponseDTO crear(@Valid @RequestBody AlumnoRequestDTO request) {
		// Validación: la fecha de nacimiento debe indicar al menos 4 años de edad
		if (request.getAlu_fecha_nacimiento() != null) {
			LocalDate fechaNac = request.getAlu_fecha_nacimiento();
			LocalDate hoy = LocalDate.now();
			int edad = Period.between(fechaNac, hoy).getYears();
			if (edad < 4) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de nacimiento debe indicar al menos 4 años de edad.");
			}
		}
		return alumnoDTOMapper.toResponseDto(
				alumnoUseCase.guardar(
						alumnoDTOMapper.toDomain(request)
						)
				);
		
	}
	
}