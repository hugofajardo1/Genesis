package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.exception.ClienteExisteException;
import com.ar.genesis.sistema.core.input.ICrearClienteInput;
import com.ar.genesis.sistema.core.repository.IClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearClienteUseCase implements ICrearClienteInput {

    IClienteRepository iClienteRepository;

    public CrearClienteUseCase(IClienteRepository iClienteRepository) {
        this.iClienteRepository = iClienteRepository;
    }

    @Override
    public boolean crearCliente(Cliente unCliente) throws ClienteExisteException {
        if(iClienteRepository.existeCliente(unCliente.getNombre())){
            throw new ClienteExisteException();
        }
        return iClienteRepository.guardarCliente(unCliente);
    }
}