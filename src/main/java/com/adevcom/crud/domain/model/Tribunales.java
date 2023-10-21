package com.adevcom.crud.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class Tribunales {
    private int id;
    private String nomTribunales;
    private boolean activo;
    private Date createdAt;
    private Date updatedAt;



}
