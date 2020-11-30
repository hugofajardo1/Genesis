package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.core.input.ITipoIvaCrearInput;
import com.ar.genesis.sistema.core.repository.ITipoIvaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoIvaUseCaseCrear implements ITipoIvaCrearInput {

    ITipoIvaRepository miTipoIvaRepository;

    public TipoIvaUseCaseCrear(ITipoIvaRepository miTipoIvaRepository) {  this.miTipoIvaRepository = miTipoIvaRepository; }

    public boolean crearTipoIva(TipoIva unTipoIva) throws TipoIvaExisteException {
        if (miTipoIvaRepository.existeTipoIva(unTipoIva.getNombre())){
            throw new TipoIvaExisteException();
        }
        return miTipoIvaRepository.guardarTipoIva(unTipoIva);
    }
}
