package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.core.input.ITipoIvaModificarInput;
import com.ar.genesis.sistema.core.repository.ITipoIvaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoIvaModificarUseCase implements ITipoIvaModificarInput {

    ITipoIvaRepository miTipoIvaRepository;

    public TipoIvaModificarUseCase(ITipoIvaRepository miTipoIvaRepository) { this.miTipoIvaRepository = miTipoIvaRepository; }

    @Override
    public boolean modificarTipoIva(TipoIva unTipoIva) throws TipoIvaExisteException {
        if(miTipoIvaRepository.existeTipoIva(unTipoIva.getNombre())){
            throw new TipoIvaExisteException();
        }
        return miTipoIvaRepository.guardarTipoIva(unTipoIva);
    }
}
