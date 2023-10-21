package com.adevcom.crud.infraestructure.mapper;

import com.adevcom.crud.domain.model.*;

import com.adevcom.crud.infraestructure.persistence.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface EscritosMapper {

    EscritosMapper INSTANCE = Mappers.getMapper(EscritosMapper.class);

    Escritos toEscritos(EscritosEntity escritosEntity);

    EscritosEntity toEscritosEntity(Escritos escritos);

    List<Escritos> mapToEscritosList(List<EscritosEntity> escritosEntityList);

    // Mapeo para la clase "Tipos"
    Tipos toTipos(TipoEntity tipoEntity);
    TipoEntity toTipoEntity(Tipos tipos);

    // Agrega mapeos para las otras clases relacionadas, como Servicios, Estados, y Tribunales
    Servicios toServicios(ServicioEntity servicioEntity);
    ServicioEntity toServicioEntity(Servicios servicios);

    Estados toEstados(EstadoEntity estadoEntity);
    EstadoEntity toEstadoEntity(Estados estados);

    Tribunales toTribunales(TribunalEntity tribunalEntity);
    TribunalEntity toTribunalEntity(Tribunales tribunales);

}



