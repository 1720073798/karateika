package com.uisrael.karateika.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AlumnoRequestDTO {
	@NotBlank
	private int alu_id;
	@NotBlank
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
	@NotBlank
	private LocalDate alu_fecha_nacimiento;
	@NotBlank
	private LocalDate alu_fecha_ingreso;
	@NotBlank
	private String alu_cinturon_ingreso;
	@NotBlank
	private String alu_cinturon_actual;
	@NotBlank
	private String alu_nombre_representante;
	@NotBlank
	private String alu_telefono_representante;
	@NotBlank
	private char alu_estado;
	@NotBlank
	private boolean alu_alerta_pago;
	@NotBlank
	private LocalDate alu_fecha_creacion;
	@NotBlank
	private LocalDate alu_fecha_modificacion;
	}
	