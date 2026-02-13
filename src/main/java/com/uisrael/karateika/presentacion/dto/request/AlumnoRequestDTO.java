package com.uisrael.karateika.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlumnoRequestDTO {
	@NotNull
	private Integer alu_id;
	@NotBlank(message = "La cédula no puede estar vacía")
    @Size(min = 10, max = 10, message = "La cédula debe tener 10 dígitos")
    @Pattern(regexp = "\\d{10}", message = "La cédula solo debe contener números")
	private String alu_cedula;
	@NotBlank
	private String alu_nombre;
	@NotBlank
	private String alu_apellido;
	@NotBlank
	private String alu_direccion;
	@NotBlank
	private String alu_telefono;
	@NotBlank
	private String alu_email;
	@NotNull
	private LocalDate alu_fecha_nacimiento;
	@NotNull
	private LocalDate alu_fecha_ingreso;
	@NotBlank
	private String alu_cinturon_ingreso;
	@NotBlank
	private String alu_cinturon_actual;
	
	private String alu_nombre_representante;
	
	private String alu_telefono_representante;
	@NotNull
	private Character alu_estado;
	@NotNull
	private Boolean alu_alerta_pago;
	@NotNull
	private LocalDate alu_fecha_creacion;
	@NotNull
	private LocalDate alu_fecha_modificacion;

	// Provide primitive-style boolean getter for compatibility with generated mappers
	public boolean isAlu_alerta_pago() {
		return Boolean.TRUE.equals(this.alu_alerta_pago);
	}
	}