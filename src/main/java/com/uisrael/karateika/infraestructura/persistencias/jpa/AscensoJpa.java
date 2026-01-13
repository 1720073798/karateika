package com.uisrael.karateika.infraestructura.persistencias.jpa;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ascenso")

public class AscensoJpa implements Serializable {


	private static final long serialVersionUID = 1L;
	

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int asc_id_serial;

	 	@ManyToOne
	    @JoinColumn(name = "alu_id", nullable = false)
	    private AlumnoJpa fkAlumno; 

	    @Column(name = "asc_cinturon", length = 50, nullable = false)
	    private String asc_cinturon;

	    @Column(name = "asc_fecha_examen", columnDefinition = "DATE")
	    private LocalDate asc_fecha_examen;

	    @Column(name = "asc_fecha_ascenso", columnDefinition = "DATE")
	    private LocalDate asc_fecha_ascenso;

	    @Column(name = "asc_calificacion")
	    private double asc_calificacion;

	    @Column(name = "asc_evaluador", length = 100)
	    private String asc_evaluador;

	    @Column(name = "asc_observacion", columnDefinition = "TEXT")
	    private String asc_observacion;

	    @Column(name = "asc_c_generado")
	    private boolean asc_c_generado;
	
	    
}

