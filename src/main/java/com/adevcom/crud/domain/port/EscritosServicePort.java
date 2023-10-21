package com.adevcom.crud.domain.port;

import com.adevcom.crud.domain.model.Escritos;

import java.util.List;


public interface EscritosServicePort {

    Escritos getEscritosById(Long id);

    void deleteEscritos(Long id);

//    Escritos updateEscritos(Long id, String title, String content);

    Escritos createEscritos(Escritos escritos);

    List<Escritos> getAllEscritos();



}
