package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadExisteException;
import com.ar.genesis.sistema.core.input.ITipoUnidadModificarInput;
import com.ar.genesis.sistema.core.repository.ITipoUnidadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoUnidadUseCaseModificar implements ITipoUnidadModificarInput {

    ITipoUnidadRepository miTipoUnidadRepository;

    public TipoUnidadUseCaseModificar(ITipoUnidadRepository miTipoUnidadRepository) { this.miTipoUnidadRepository = miTipoUnidadRepository; }

    @Override
    public boolean modificarTipoUnidad(TipoUnidad unTipoUnidad) throws TipoUnidadExisteException {
        if(miTipoUnidadRepository.existeTipoUnidad(unTipoUnidad.getNombre())){
            throw new TipoUnidadExisteException();
        }
        return miTipoUnidadRepository.guardarTipoUnidad(unTipoUnidad);
    }
}
