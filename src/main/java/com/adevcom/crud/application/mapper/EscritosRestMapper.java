package com.adevcom.crud.application.mapper;


import com.adevcom.crud.application.model.EscritosRequest;
import com.adevcom.crud.application.model.EscritosResponse;
import com.adevcom.crud.domain.model.Escritos;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;
@Mapper
public interface EscritosRestMapper {

    EscritosRestMapper INSTANCE = Mappers.getMapper(EscritosRestMapper.class);

    Escritos toEscritos(EscritosRequest escritosRequest);

    EscritosResponse toEscritosResponse(Escritos escritos);

    List<EscritosResponse> mapToEscritosListResponse(List<Escritos> escritosList);

}

