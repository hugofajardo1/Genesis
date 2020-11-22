package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.core.input.IModificarTipoIvaInput;
import com.ar.genesis.sistema.core.repository.ITipoIvaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModificarTipoIvaUseCase implements IModificarTipoIvaInput {

    ITipoIvaRepository iTipoIvaRepository;

    public ModificarTipoIvaUseCase(ITipoIvaRepository iTipoIvaRepository) {
        this.iTipoIvaRepository = iTipoIvaRepository;
    }

    @Override
    public boolean modificarTipoIva(TipoIva unTipoIva) throws TipoIvaExisteException {
        if(iTipoIvaRepository.existeTipoIva(unTipoIva.getNombre())){
            throw new TipoIvaExisteException();
        }
        return iTipoIvaRepository.guardarTipoIva(unTipoIva);
    }
}