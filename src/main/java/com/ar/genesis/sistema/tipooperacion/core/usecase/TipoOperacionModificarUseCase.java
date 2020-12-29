package com.ar.genesis.sistema.tipooperacion.core.usecase;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionExisteException;
import com.ar.genesis.sistema.tipooperacion.core.input.ITipoOperacionModificarInput;
import com.ar.genesis.sistema.tipooperacion.core.repository.ITipoOperacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoOperacionModificarUseCase implements ITipoOperacionModificarInput {

    ITipoOperacionRepository miTipoOperacionRepository;

    public TipoOperacionModificarUseCase(ITipoOperacionRepository miTipoOperacionRepository) { this.miTipoOperacionRepository = miTipoOperacionRepository; }

    @Override
    public boolean modificarTipoOperacion(TipoOperacion unTipoOperacion) throws TipoOperacionExisteException {
        if(miTipoOperacionRepository.existeTipoOperacion(unTipoOperacion.getNombre())){
            throw new TipoOperacionExisteException();
        }
        return miTipoOperacionRepository.guardarTipoOperacion(unTipoOperacion);
    }
}
