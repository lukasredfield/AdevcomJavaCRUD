package com.adevcom.crud.infraestructure.persistence;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "tipos")
public class TipoEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nom_tipo", length = 50, nullable = false)
    private String nomTipo;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // Getters and setters
}
