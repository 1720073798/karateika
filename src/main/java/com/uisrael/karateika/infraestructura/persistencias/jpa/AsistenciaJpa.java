package com.uisrael.karateika.infraestructura.persistencias.jpa;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "asistencias")
public class AsistenciaJpa implements Serializable {

	
	private static final long serialVersionUID = 1L;
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "asi_id")
	    private int asi_id;

	 	@ManyToOne
	    @JoinColumn(name = "alu_id", nullable = false)
	    private AlumnoJpa fkAlumno; 

	    @Column(name = "asi_fecha", nullable = false)
	    private LocalDate asi_fecha;

	    @Column(name = "asi_hora", nullable = false)
	    private LocalTime asi_hora;

	    @Column(name = "asi_estado", length = 2, nullable = false)
	    private String asi_estado;  

	    @Column(name = "asi_observacion", columnDefinition = "TEXT")
	    private String asi_observacion;
}
