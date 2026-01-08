package com.uisrael.karateika.infraestructura.persistencias.jpa;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "alumno")
public class AlumnoJpa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int alu_id;
	
	@Column(name = "alu_nombre", length = 100, nullable = false)
	private String alu_nombre;
	
	@Column(name = "alu_fecha_nacimiento", columnDefinition = "DATE")
	private LocalDate alu_fecha_nacimiento;
	
	@Column(name = "alu_cedula", length = 10, nullable = false)
	private String alu_cedula;
	
	@Column(name = "alu_apellido", length = 100, nullable = false)
	private String alu_apellido;
	
	@Column(name = "alu_direccion", length = 150, nullable = false)
	private String alu_direccion;
	
	@Column(name = "alu_telefono", length = 15, nullable = false)
	private String alu_telefono;
	
	@Column(name = "alu_email", length = 100, nullable = false)
	private String alu_email;
	
	@Column(name = "alu_fecha_ingreso", columnDefinition = "DATE")
	private LocalDate alu_fecha_ingreso;
	
	@Column(name = "alu_cinturon_ingreso", length = 50, nullable = false)
	private String alu_cinturon_ingreso;
	
	@Column(name = "alu_cinturon_actual", length = 50, nullable = false)
	private String alu_cinturon_actual;
	
	@Column(name = "alu_nombre_representante", length = 100, nullable = false)
	private String alu_nombre_representante;
	
	@Column(name = "alu_telefono_representante", length = 15, nullable = false)
	private String alu_telefono_representante;
	
	@Column(name = "alu_estado", nullable = false)
	private char alu_estado;
	
	@Column(name = "alu_alerta_pago", nullable = false)
	private boolean alu_alerta_pago;
	
	@Column(name = "alu_fecha_creacion", columnDefinition = "DATE")
	private LocalDate alu_fecha_creacion;
	
	@Column(name = "alu_fecha_modificacion", columnDefinition = "DATE")
	private LocalDate alu_fecha_modificacion;

}