package com.adevcom.crud.infraestructure.persistence;

import com.adevcom.crud.domain.model.Escritos;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "escritos")
public class EscritosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nro_escritos", nullable = false)
    private int nroEscritos;

    @ManyToOne
    @JoinColumn(name = "tipo_id", nullable = false)
    private TipoEntity tipo;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private ServicioEntity servicio;

    @Column(name = "jurisdiccion", nullable = false)
    private int jurisdiccion;

    @ManyToOne
    @JoinColumn(name = "tribunal_id", nullable = false)
    private TribunalEntity tribunal;

    @Column(name = "asunto", nullable = true, length = 255)
    private String asunto;

    @Column(name = "fec_ingreso", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngreso;

    @Column(name = "nro_causa", nullable = false)
    private int nroCausa;

    @Column(name = "observacion", nullable = false, length = 255)
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private EstadoEntity estado;

    @Column(name = "created_at", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "recepcion", nullable = false)
    @Enumerated(EnumType.STRING)
    private Escritos.EstadosEscrito recepcion = Escritos.EstadosEscrito.PENDIENTE;


    // Getters and setters
}
