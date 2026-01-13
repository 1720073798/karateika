package com.uisrael.karateika.infraestructura.persistencias.jpa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "comprobante")
public class ComprobanteJpa implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private int com_id;
	
	@Column (name = "com_nombre", length = 255, nullable = false)
    private String com_nombre;
	
	@Column(name = "com_ruta_archivo", length = 500, nullable = false)
    private String com_ruta_archivo;

    @Column(name = "com_fecha_subida", columnDefinition = "DATE")
    private LocalDate com_fecha_subida;
	
    @OneToMany(mappedBy = "fkComprobante")
    private List<PagosJpa> pagos;
}
