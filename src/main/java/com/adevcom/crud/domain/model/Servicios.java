package com.adevcom.crud.domain.model;

import lombok.Data;

import java.util.Date;
@Data
public class Servicios {
    private int id;
    private String nomServicio;
    private boolean activo;
    private Date createdAt;
    private Date updatedAt;



}
