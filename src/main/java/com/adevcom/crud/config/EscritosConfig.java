package com.adevcom.crud.config;

import com.adevcom.crud.domain.port.EscritosPersistencePort;
import com.adevcom.crud.domain.port.EscritosServicePort;
import com.adevcom.crud.domain.service.EscritosServicePortImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EscritosConfig {

    @Bean
    public EscritosServicePort escritosService(EscritosPersistencePort escritosPersistencePort){
        return new EscritosServicePortImp(escritosPersistencePort);
    }

}