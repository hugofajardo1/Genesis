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

    ITipoIvaRepository miTipoIvaRepository;

    public CrearTipoIvaUseCase(ITipoIvaRepository miTipoIvaRepository) {  this.miTipoIvaRepository = miTipoIvaRepository; }

    public boolean crearTipoIva(TipoIva unTipoIva) throws TipoIvaExisteException {
        if (miTipoIvaRepository.existeTipoIva(unTipoIva.getNombre())){
            throw new TipoIvaExisteException();
        }
        return miTipoIvaRepository.guardarTipoIva(unTipoIva);
    }
}
