package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoIvaInput;
import com.ar.genesis.sistema.core.repository.ITipoIvaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearTipoIvaUseCase implements ICrearTipoIvaInput {

    ITipoIvaRepository iTipoIvaRepository;

    public CrearTipoIvaUseCase(ITipoIvaRepository iTipoIvaRepository) {
        this.iTipoIvaRepository = iTipoIvaRepository;
    }

    public boolean crearTipoIva(TipoIva tipoIvaNueva) throws TipoIvaExisteException {
        if (iTipoIvaRepository.existeTipoIva(tipoIvaNueva.getNombre())){
            throw new TipoIvaExisteException();
        }
        return iTipoIvaRepository.guardarTipoIva(tipoIvaNueva);
    }
}
