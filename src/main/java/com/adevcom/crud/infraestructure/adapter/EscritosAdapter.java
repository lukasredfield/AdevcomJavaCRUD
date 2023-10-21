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
        return escritosEntity.map(entity -> EscritosMapper.INSTANCE.toEscritos(entity)).orElse(null);
    }


    @Override
    public void deleteEscritos(Long id) {
        this.escritosRepository.deleteById(id);

    }

//    @Override
//    public Escritos updateEscritos(Long id, int nroEscritos, Tipos tipo, Servicios servicio, int jurisdiccion, Tribunales tribunal, String asunto, Date fecIngreso, int nroCausa, String observacion, Estados estado) {
//        Optional<EscritosEntity> existingEscritos = this.escritosRepository.findById(id);
//
//        if (existingEscritos == null) {
//            // Manejo de error: No se encontró el registro con el ID proporcionado.
//            return null;
//        }
//
//        // Actualizar las propiedades que deseas cambiar
//        existingEscritos.setNroEscritos(nroEscritos);
//        existingEscritos.setTipos(tipo);
//        existingEscritos.setServicio(servicio);
//        existingEscritos.setJurisdiccion(jurisdiccion);
//        existingEscritos.setTribunal(tribunal);
//        existingEscritos.setAsunto(asunto);
//        existingEscritos.setFecIngreso(fecIngreso);
//        existingEscritos.setNroCausa(nroCausa);
//        existingEscritos.setObservacion(observacion);
//        existingEscritos.setEstado(estado);
//        existingEscritos.setUpdatedAt(new Date());
//
//        // Llama al método de persistencia para actualizar el registro en la base de datos
//        return this.escritosPersistencePort.updateEscritos(existingEscritos);
//    }


    @Override
    public Escritos createEscritos(Escritos taskModel) {
        EscritosEntity newEscritos = this.escritosRepository
                .save(EscritosMapper.INSTANCE.toEscritosEntity(taskModel));
        return EscritosMapper.INSTANCE.toEscritos(newEscritos);
    }

    @Override
    public List<Escritos> getAllEscritos(){
        List<EscritosEntity> entityList = this.escritosRepository.findAll();
        return EscritosMapper.INSTANCE.mapToEscritosList(entityList);
    }
}
