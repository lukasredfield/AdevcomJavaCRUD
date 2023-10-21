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

        EscritosResponse escritosResponse = EscritosRestMapper.INSTANCE.toEscritosResponse(escritos);
        this.escritosServicePort.createEscritos(escritos);
        return ResponseEntity.ok().body(escritosResponse);  // ARREGLAR LA RESPUESTA DE "escritosResponse" !!!!!!!!!!!
    }



    @GetMapping("/{id}")
    public ResponseEntity<EscritosResponse> getEscritos(@PathVariable Long id){
        EscritosResponse escritosFound = EscritosRestMapper.INSTANCE.toEscritosResponse(escritosServicePort.getEscritosById(id));
        return ResponseEntity.ok(escritosFound);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EscritosResponse>> getAllEscritos(){
        return ResponseEntity.ok(EscritosRestMapper.INSTANCE.
                mapToEscritosListResponse(this.escritosServicePort.getAllEscritos()));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<EscritosResponse> deleteEscritos(@PathVariable Long id) {
        this.escritosServicePort.deleteEscritos(id);
        return ResponseEntity.ok().body(null);
    }


//    @PutMapping("/update/{id}")
//    public ResponseEntity<EscritosResponse> updateTask(@RequestBody EscritosRequest taskRequest, @PathVariable Long id){
//        EscritosResponse taskResponse = EscritosRestMapper.INSTANCE.toEscritosResponse(this.taskServicePort.updateEscritos(id, taskRequest.getTitle(), taskRequest.getContent()));
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
//    }


}
