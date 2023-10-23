package com.adevcom.crud.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Escritos {

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
    private EstadosEscrito recepcion = EstadosEscrito.PENDIENTE;

    public enum EstadosEscrito {
        PENDIENTE,
        RECEPCIONADO,
        SIN_CAUSA
    }


    public static Escritos createNewEscrito(int nroEscritos, Tipos tipo, Servicios servicio, int jurisdiccion, Tribunales tribunal, String asunto, Date fecIngreso, int nroCausa, String observacion, Estados estado) {
        Escritos escritos = new Escritos();
        escritos.setNroEscritos(nroEscritos);
        escritos.setTipo(tipo);
        escritos.setServicio(servicio);
        escritos.setJurisdiccion(jurisdiccion);
        escritos.setTribunal(tribunal);
        escritos.setAsunto(asunto);
        escritos.setFecIngreso(fecIngreso);
        escritos.setNroCausa(nroCausa);
        escritos.setObservacion(observacion);
        escritos.setEstado(estado);
        escritos.setCreatedAt(new Date());
        escritos.setRecepcion(EstadosEscrito.PENDIENTE); // Establece el estado de recepción como "PENDIENTE"
        return escritos;
    }



}
