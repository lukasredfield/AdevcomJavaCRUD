package com.adevcom.crud.config;

import com.adevcom.crud.domain.model.Estados;
import com.adevcom.crud.domain.model.Servicios;
import com.adevcom.crud.domain.model.Tipos;
import com.adevcom.crud.domain.model.Tribunales;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {

    @Bean
    public Estados estadosBean() {
        return new Estados(); // Esto depende de cómo inicialices Estados
    }

    @Bean
    public Tipos tiposBean() {
        return new Tipos(); // Esto depende de cómo inicialices Tipos
    }

    @Bean
    public Servicios serviciosBean() {
        return new Servicios(); // Esto depende de cómo inicialices Servicios
    }

    @Bean
    public Tribunales tribunalesBean() {
        return new Tribunales(); // Esto depende de cómo inicialices Tribunales
    }
}

