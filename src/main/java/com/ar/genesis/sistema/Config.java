package com.ar.genesis.sistema;

import com.ar.genesis.sistema.core.repository.IClienteRepository;
import com.ar.genesis.sistema.core.usecase.CrearClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Autowired
    IClienteRepository iClienteRepository;

    @Bean
    public CrearClienteUseCase crearClienteUseCase() { return new CrearClienteUseCase(iClienteRepository); }

}
