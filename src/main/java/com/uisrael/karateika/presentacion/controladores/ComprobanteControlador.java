package com.uisrael.karateika.presentacion.controladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.karateika.aplicacion.casouso.entradas.IComprobanteUseCase;
import com.uisrael.karateika.presentacion.dto.request.ComprobanteRequestDTO;
import com.uisrael.karateika.presentacion.dto.response.ComprobanteResponseDTO;
import com.uisrael.karateika.presentacion.mapeadores.IComprobanteDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comprobantes")
public class ComprobanteControlador {

	private static final Logger logger = LoggerFactory.getLogger(ComprobanteControlador.class);

	private static final String UPLOAD_DIR = "comprobantes/";

	private final IComprobanteUseCase comprobanteUseCase;
	private final IComprobanteDtoMapper mapper;

	public ComprobanteControlador(IComprobanteUseCase comprobanteUseCase, IComprobanteDtoMapper mapper) {
		this.comprobanteUseCase = comprobanteUseCase;
		this.mapper = mapper;
		crearDirectorio();
	}

	// ===================== GET =====================

	@GetMapping
	public List<ComprobanteResponseDTO> listar() {
		return comprobanteUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/buscarid/{id}")
	public ComprobanteResponseDTO buscarPorId(@PathVariable int id) {
		return comprobanteUseCase.buscarPorId(id).map(mapper::toResponseDto)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comprobante no encontrado"));
	}

	// ===================== POST (CREAR / ACTUALIZAR) =====================

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ComprobanteResponseDTO guardar(@Valid @RequestPart("comprobante") ComprobanteRequestDTO request,
			@RequestPart(value = "archivo", required = false) MultipartFile archivo) {

		validarNumeroUnico(request);

		if (archivo != null && !archivo.isEmpty()) {
			procesarArchivo(request, archivo);
		}

		return mapper.toResponseDto(comprobanteUseCase.guardar(mapper.toDomain(request)));
	}

	// ===================== DELETE =====================

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		comprobanteUseCase.buscarPorId(id).ifPresent(this::eliminarArchivoFisico);
		comprobanteUseCase.eliminar(id);
	}

	// ===================== MÉTODOS PRIVADOS =====================

	private void crearDirectorio() {
		try {
			Files.createDirectories(Paths.get(UPLOAD_DIR));
		} catch (IOException e) {
			throw new RuntimeException("No se pudo crear el directorio de comprobantes", e);
		}
	}

	private void validarNumeroUnico(ComprobanteRequestDTO request) {
		boolean existe = comprobanteUseCase.listarTodos().stream()
				.anyMatch(c -> c.getCom_numero() == request.getCom_numero() && c.getCom_id() != request.getCom_id());

		if (existe) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"El número de comprobante " + request.getCom_numero() + " ya existe");
		}
	}

	private void procesarArchivo(ComprobanteRequestDTO request, MultipartFile archivo) {

		validarArchivo(archivo);

		if (request.getCom_id() != 0) {
			comprobanteUseCase.buscarPorId(request.getCom_id()).ifPresent(this::eliminarArchivoFisico);
		}

		try {
			String nombreArchivo = generarNombreArchivo(archivo);
			Path destino = Paths.get(UPLOAD_DIR + nombreArchivo);

			Files.copy(archivo.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

			request.setCom_ruta_archivo(UPLOAD_DIR + nombreArchivo);

		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el archivo", e);
		}
	}

	private void validarArchivo(MultipartFile archivo) {
		String contentType = archivo.getContentType();

		if (contentType == null || (!contentType.equals("application/pdf") && !contentType.startsWith("image/"))) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solo se permiten archivos PDF o imágenes");
		}

		if (archivo.getSize() > 5 * 1024 * 1024) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El archivo no puede exceder 5MB");
		}
	}

	private void eliminarArchivoFisico(com.uisrael.karateika.dominio.entidades.Comprobante comprobante) {

		String ruta = comprobante.getCom_ruta_archivo();

		if (ruta != null && !ruta.isEmpty()) {
			try {
				Files.deleteIfExists(Paths.get(ruta));
				logger.info("Archivo eliminado: {}", ruta);
			} catch (IOException e) {
				logger.warn("No se pudo eliminar archivo: {}", e.getMessage());
			}
		}
	}

	private String generarNombreArchivo(MultipartFile archivo) {
		String extension = getExtension(archivo.getOriginalFilename());
		return UUID.randomUUID() + "." + extension;
	}

	private String getExtension(String filename) {
		if (filename == null || !filename.contains("."))
			return "pdf";
		return filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
	}
}
