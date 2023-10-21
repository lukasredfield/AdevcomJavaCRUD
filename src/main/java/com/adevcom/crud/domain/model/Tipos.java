package com.adevcom.crud.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class Tipos {
    private int id;
    private String nomTipo;
    private boolean activo;
    private Date createdAt;
    private Date updatedAt;

}
