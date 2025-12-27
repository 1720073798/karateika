package com.uisrael.karateika.infraestructura.persistencias.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cinturon")
public class CinturonJpa implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cin_id;
	
	@Column(name = "cin_nombre", length = 50, nullable = false)
	private String cin_nombre;
	
	@Column(name = "cin_nivel", length = 50, nullable = false)
	private String cin_nivel;
	
	@Column(name = "cin_descripcion", length = 100, nullable = false)
	private String cin_descripcion;

}
