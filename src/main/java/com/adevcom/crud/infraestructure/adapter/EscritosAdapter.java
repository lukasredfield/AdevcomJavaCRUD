package com.adevcom.crud.infraestructure.adapter;

import com.adevcom.crud.domain.model.*;
import com.adevcom.crud.domain.port.EscritosPersistencePort;
import com.adevcom.crud.infraestructure.mapper.EscritosMapper;
import com.adevcom.crud.infraestructure.persistence.EscritosEntity;
import com.adevcom.crud.infraestructure.repository.EscritosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.adevcom.crud.domain.model.Escritos.EstadosEscrito;


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
        return escritosEntity.map(entity -> {
            Escritos escritos = EscritosMapper.INSTANCE.toEscritos(entity);
            escritos.setRecepcion(entity.getRecepcion());
            return escritos;
        }).orElse(null);
    }

    @Override
    public void deleteEscritos(Long id) {
        this.escritosRepository.deleteById(id);
    }

    @Override
    public Escritos updateEscritos(Escritos escritos) {
        // Primero, verifica si el Escritos que deseas actualizar existe en la base de datos
        Optional<EscritosEntity> existingEntityOptional = escritosRepository.findById(escritos.getId());

        if (existingEntityOptional.isEmpty()) {
            // El Escritos no existe, por lo que no se puede actualizar
            return null;
        }

        // Convierte el objeto Escritos a EscritosEntity para actualizar los valores en la base de datos
        EscritosEntity existingEntity = existingEntityOptional.get();
        existingEntity.setNroEscritos(escritos.getNroEscritos());
        existingEntity.setRecepcion(escritos.getRecepcion());


        // Actualiza las propiedades relacionadas
        existingEntity.setTipo(EscritosMapper.INSTANCE.toTipoEntity(escritos.getTipo()));
        existingEntity.setServicio(EscritosMapper.INSTANCE.toServicioEntity(escritos.getServicio()));
        existingEntity.setTribunal(EscritosMapper.INSTANCE.toTribunalEntity(escritos.getTribunal()));
        existingEntity.setAsunto(escritos.getAsunto());
        existingEntity.setFecIngreso(escritos.getFecIngreso());
        existingEntity.setNroCausa(escritos.getNroCausa());
        existingEntity.setObservacion(escritos.getObservacion());
        existingEntity.setEstado(EscritosMapper.INSTANCE.toEstadoEntity(escritos.getEstado()));
        existingEntity.setUpdatedAt(new Date()); // Actualiza la fecha de modificación

        // Guarda los cambios actualizados en la base de datos
        EscritosEntity updatedEntity = escritosRepository.save(existingEntity);

        // Convierte el EscritosEntity actualizado a un objeto Escritos y devuélvelo
        return EscritosMapper.INSTANCE.toEscritos(updatedEntity);
    }

    @Override
    public Escritos createEscritos(Escritos escritos) {
        escritos.setRecepcion(Escritos.EstadosEscrito.PENDIENTE); // Establece el valor predeterminado
        EscritosEntity newEscritos = this.escritosRepository.save(EscritosMapper.INSTANCE.toEscritosEntity(escritos));
        return EscritosMapper.INSTANCE.toEscritos(newEscritos);
    }

    @Override
    public List<Escritos> getAllEscritos() {
        List<EscritosEntity> entityList = this.escritosRepository.findAll();
        return EscritosMapper.INSTANCE.mapToEscritosList(entityList);
    }
}
