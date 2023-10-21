package com.adevcom.crud.domain.service;


import com.adevcom.crud.domain.model.*;
import com.adevcom.crud.domain.port.EscritosPersistencePort;
import com.adevcom.crud.domain.port.EscritosServicePort;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class EscritosServicePortImp implements EscritosServicePort {

    private final EscritosPersistencePort escritosPersistencePort;

    @Override
    public Escritos getEscritosById(Long id) {
        return this.escritosPersistencePort.getEscritosById(id);
    }

    @Override
    public void deleteEscritos(Long id) {
        this.escritosPersistencePort.deleteEscritos(id);
    }


    @Override
    public Escritos createEscritos(Escritos escritos) {
        return this.escritosPersistencePort.createEscritos(escritos);
    }

    @Override
    public List<Escritos> getAllEscritos() {
        return this.escritosPersistencePort.getAllEscritos();
    }

    @Override
    public Escritos updateEscritos(Long id, int nroEscritos, Tipos tipo, Servicios servicio, int jurisdiccion, Tribunales tribunal, String asunto, Date fecIngreso, int nroCausa, String observacion, Estados estado) {
        // Obtén el Escritos existente por su ID
        Escritos existingEscritos = this.escritosPersistencePort.getEscritosById(id);

        if (existingEscritos == null) {
            // Maneja el caso en el que el Escritos no se encuentra
            return null;
        }

        // Actualiza los campos necesarios
        existingEscritos.setNroEscritos(nroEscritos);
        existingEscritos.setTipo(tipo);
        existingEscritos.setServicio(servicio);
        existingEscritos.setJurisdiccion(jurisdiccion);
        existingEscritos.setTribunal(tribunal);
        existingEscritos.setAsunto(asunto);
        existingEscritos.setFecIngreso(fecIngreso);
        existingEscritos.setNroCausa(nroCausa);
        existingEscritos.setObservacion(observacion);
        existingEscritos.setEstado(estado);

        // Actualiza la fecha de actualización
        existingEscritos.setUpdatedAt(new Date());

        // Guarda el Escritos actualizado en la base de datos
        Escritos updatedEscritos = this.escritosPersistencePort.updateEscritos(existingEscritos);

        return updatedEscritos;
    }

}

