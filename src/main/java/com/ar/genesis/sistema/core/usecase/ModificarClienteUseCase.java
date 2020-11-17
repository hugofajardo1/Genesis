package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.exception.ClienteExisteException;
import com.ar.genesis.sistema.core.input.IModificarClienteInput;
import com.ar.genesis.sistema.core.repository.IClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModificarClienteUseCase implements IModificarClienteInput {

    IClienteRepository iClienteRepository;

    public ModificarClienteUseCase(IClienteRepository iClienteRepository) {
        this.iClienteRepository = iClienteRepository;
    }

    @Override
    public boolean modificarCliente(Cliente unCliente) throws ClienteExisteException {
        if (iClienteRepository.existeCliente(unCliente.getNombre())){
            throw new ClienteExisteException();
        }
        return iClienteRepository.guardarCliente(unCliente);
    }
}
