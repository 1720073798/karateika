package com.uisrael.karateika.presentacion.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class AsistenciaResponseDTO {

    private Integer asiId;
    private Integer aluId;
    private LocalDate asiFecha;
    private LocalTime asiHora;
    private String asiEstado;
    private String asiObservacion;
    
}

