package com.adevcom.crud.domain.port;

import com.adevcom.crud.domain.model.*;

import java.util.Date;
import java.util.List;


public interface EscritosServicePort {

    Escritos getEscritosById(Long id);

    void deleteEscritos(Long id);

    Escritos updateEscritos(Long id, int nroEscritos, Tipos tipo, Servicios servicio, int jurisdiccion, Tribunales tribunal, String asunto, Date fecIngreso, int nroCausa, String observacion, Estados estado);

    Escritos createEscritos(Escritos escritos);

    List<Escritos> getAllEscritos();



}
