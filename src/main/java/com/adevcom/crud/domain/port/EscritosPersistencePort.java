package com.adevcom.crud.domain.port;

import com.adevcom.crud.domain.model.Escritos;


import java.util.List;

public interface EscritosPersistencePort {

    Escritos getEscritosById(Long id);

    void deleteEscritos(Long id);

//    Escritos updateEscritos(Long id, String title, String content);

    Escritos createEscritos(Escritos writings);

    List<Escritos> getAllEscritos();

}
