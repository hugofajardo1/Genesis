package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoCliente;
import com.ar.genesis.sistema.core.exception.TipoClienteExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoClienteInput;
import com.ar.genesis.sistema.core.repository.ITipoClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearTipoClienteUseCase implements ICrearTipoClienteInput {

    ITipoClienteRepository iTipoClienteRepository;

    public CrearTipoClienteUseCase(ITipoClienteRepository iTipoClienteRepository) {
        this.iTipoClienteRepository = iTipoClienteRepository;
    }

    @Override
    public boolean crearTipoCliente(TipoCliente unTipoCliente) throws TipoClienteExisteException {
        if(iTipoClienteRepository.existeTipoCliente(unTipoCliente.getNombre())){
            throw new TipoClienteExisteException();
        }
        return iTipoClienteRepository.guardarTipoCliente(unTipoCliente);
    }
}
