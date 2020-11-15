package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.exception.ClienteExisteException;
import com.ar.genesis.sistema.core.input.ICrearClienteInput;
import com.ar.genesis.sistema.core.repository.IClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class CrearClienteUseCase implements ICrearClienteInput {

    @Inject
    IClienteRepository clienteRepository;

    @Override
    public boolean crearCliente(Cliente unCliente) throws ClienteExisteException {
        if(clienteRepository.existeCliente(unCliente.getNombre())){
            throw new ClienteExisteException();
        }
        return clienteRepository.guardarCliente(unCliente);
    }
}