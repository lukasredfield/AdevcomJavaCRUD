package com.adevcom.crud.domain.service;


import com.adevcom.crud.domain.model.Escritos;
import com.adevcom.crud.domain.port.EscritosPersistencePort;
import com.adevcom.crud.domain.port.EscritosServicePort;
import lombok.RequiredArgsConstructor;

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

//    @Override
//    public Escritos updateEscritos(Long id, String title, String content) {
//        return this.escritosPersistencePort.updateEscritos(id, title, content);
//    }

    @Override
    public Escritos createEscritos(Escritos escritos) {
        return this.escritosPersistencePort.createEscritos(escritos);
    }

    @Override
    public List<Escritos> getAllEscritos() {
        return this.escritosPersistencePort.getAllEscritos();
    }
}

