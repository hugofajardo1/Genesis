package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.exception.ClienteExisteException;
import com.ar.genesis.sistema.core.input.ICrearClienteInput;
import com.ar.genesis.sistema.core.repository.IClienteRepository;

public class CrearClienteUseCase implements ICrearClienteInput {

    IClienteRepository clienteRepository;

    public CrearClienteUseCase(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public boolean crearCliente(Cliente unCliente) throws ClienteExisteException {
        if(clienteRepository.existeCliente(unCliente.getNombre())){
            throw new ClienteExisteException();
        }
        return clienteRepository.guardarCliente(unCliente);
    }
}