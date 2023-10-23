package com.adevcom.crud.application.model;

import com.adevcom.crud.domain.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class EscritosRequest {
    private Long id;
    private int nroEscritos;
    private Tipos tipo;
    private Servicios servicio;
    private int jurisdiccion;
    private Tribunales tribunal;
    private String asunto;
    private Date fecIngreso;
    private int nroCausa;
    private String observacion;
    private Estados estado;
    private Date createdAt;
    private Date updatedAt;
    private Escritos.EstadosEscrito recepcion;


    // Getters y setters
}


