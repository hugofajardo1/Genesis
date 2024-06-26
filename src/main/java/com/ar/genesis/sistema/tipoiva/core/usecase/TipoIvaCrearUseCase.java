package com.ar.genesis.sistema.tipoiva.core.usecase;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.tipoiva.core.input.ITipoIvaCrearInput;
import com.ar.genesis.sistema.tipoiva.core.repository.ITipoIvaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoIvaCrearUseCase implements ITipoIvaCrearInput {

    ITipoIvaRepository miTipoIvaRepository;

    public TipoIvaCrearUseCase(ITipoIvaRepository miTipoIvaRepository) {  this.miTipoIvaRepository = miTipoIvaRepository; }

    public boolean crearTipoIva(TipoIva unTipoIva) throws TipoIvaExisteException {
        if (miTipoIvaRepository.existeTipoIva(unTipoIva.getNombre())){
            throw new TipoIvaExisteException();
        }
        return miTipoIvaRepository.guardarTipoIva(unTipoIva);
    }
}
