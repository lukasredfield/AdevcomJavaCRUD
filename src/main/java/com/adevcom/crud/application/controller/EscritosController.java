package com.adevcom.crud.application.controller;


import com.adevcom.crud.application.mapper.EscritosRestMapper;
import com.adevcom.crud.application.model.EscritosRequest;
import com.adevcom.crud.application.model.EscritosResponse;
import com.adevcom.crud.domain.model.*;
import com.adevcom.crud.domain.port.EscritosServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/adevcom")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:28709", allowedHeaders = "*")
public class EscritosController {

    private final EscritosServicePort escritosServicePort;

    @PostMapping("/new")
    public ResponseEntity<EscritosResponse> newEscrito(@RequestBody EscritosRequest escritosRequest) {
        // Mapear el EscritosRequest a un Escritos
        Escritos escritos = EscritosRestMapper.INSTANCE.toEscritos(escritosRequest);

        // Asignar las relaciones directamente desde EscritosRequest
        escritos.setEstado(escritosRequest.getEstado());
        escritos.setTipo(escritosRequest.getTipo());
        escritos.setServicio(escritosRequest.getServicio());
        escritos.setTribunal(escritosRequest.getTribunal());
        escritos.setCreatedAt(new Date());

        // Establece el valor predeterminado de "recepcion" a "PENDIENTE"
        escritos.setRecepcion(Escritos.EstadosEscrito.PENDIENTE);


        EscritosResponse escritosResponse = EscritosRestMapper.INSTANCE.toEscritosResponse(escritos);
        this.escritosServicePort.createEscritos(escritos);
        return ResponseEntity.ok().body(escritosResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscritosResponse> getEscritos(@PathVariable Long id) {
        EscritosResponse escritosFound = EscritosRestMapper.INSTANCE.toEscritosResponse(escritosServicePort.getEscritosById(id));
        return ResponseEntity.ok(escritosFound);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EscritosResponse>> getAllEscritos() {
        return ResponseEntity.ok(EscritosRestMapper.INSTANCE.mapToEscritosListResponse(this.escritosServicePort.getAllEscritos()));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<EscritosResponse> deleteEscritos(@PathVariable Long id) {
        this.escritosServicePort.deleteEscritos(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EscritosResponse> updateEscrito(@RequestBody EscritosRequest escritosRequest, @PathVariable Long id) {
        // Obtén el Escritos existente por ID
        Escritos existingEscritos = this.escritosServicePort.getEscritosById(id);

        // Verifica si el Escritos existente es nulo
        if (existingEscritos == null) {
            return ResponseEntity.notFound().build();
        }

        // Llama al servicio para actualizar el Escritos utilizando los parámetros adecuados
        Escritos updatedEscritos = this.escritosServicePort.updateEscritos(
                id,
                escritosRequest.getNroEscritos(),
                escritosRequest.getTipo(),
                escritosRequest.getServicio(),
                escritosRequest.getJurisdiccion(),
                escritosRequest.getTribunal(),
                escritosRequest.getAsunto(),
                escritosRequest.getFecIngreso(),
                escritosRequest.getNroCausa(),
                escritosRequest.getObservacion(),
                escritosRequest.getEstado()
        );

        // Verifica si el Escritos se actualizó con éxito
        if (updatedEscritos == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualiza el campo "recepcion" si es proporcionado
        if (escritosRequest.getRecepcion() != null) {
            updatedEscritos.setRecepcion(escritosRequest.getRecepcion());
        }

        // Mapea el resultado actualizado a la respuesta y devuélvela
        EscritosResponse escritosResponse = EscritosRestMapper.INSTANCE.toEscritosResponse(updatedEscritos);
        return ResponseEntity.ok(escritosResponse);
    }
}
