package com.adevcom.crud.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class Estados {
    private int id;
    private String nomEstados;
    private boolean activo;
    private Date createdAt;
    private Date updatedAt;

}
