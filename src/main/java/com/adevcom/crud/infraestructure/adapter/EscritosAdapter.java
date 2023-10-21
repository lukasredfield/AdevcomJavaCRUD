package com.adevcom.crud.infraestructure.adapter;


import com.adevcom.crud.domain.model.*;
import com.adevcom.crud.domain.port.EscritosPersistencePort;
import com.adevcom.crud.infraestructure.mapper.EscritosMapper;
import com.adevcom.crud.infraestructure.persistence.EscritosEntity;
import com.adevcom.crud.infraestructure.repository.EscritosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EscritosAdapter implements EscritosPersistencePort {

    public final EscritosRepository escritosRepository;

    @Override
    public Escritos getEscritosById(Long id) {
        Optional<EscritosEntity> escritosEntity = this.escritosRepository.findById(id);
        return escritosEntity.map(EscritosMapper.INSTANCE::toEscritos).orElse(null);
    }


    @Override
    public void deleteEscritos(Long id) {
        this.escritosRepository.deleteById(id);

    }


    @Override
    public Escritos createEscritos(Escritos escritos) {
        EscritosEntity newEscritos = this.escritosRepository
                .save(EscritosMapper.INSTANCE.toEscritosEntity(escritos));
        return EscritosMapper.INSTANCE.toEscritos(newEscritos);
    }

    @Override
    public List<Escritos> getAllEscritos(){
        List<EscritosEntity> entityList = this.escritosRepository.findAll();
        return EscritosMapper.INSTANCE.mapToEscritosList(entityList);
    }
}
