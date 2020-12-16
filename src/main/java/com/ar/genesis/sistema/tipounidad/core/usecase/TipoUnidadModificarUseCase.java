package com.ar.genesis.sistema.tipounidad.core.usecase;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.core.exception.TipoUnidadExisteException;
import com.ar.genesis.sistema.tipounidad.core.input.ITipoUnidadModificarInput;
import com.ar.genesis.sistema.tipounidad.core.repository.ITipoUnidadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoUnidadModificarUseCase implements ITipoUnidadModificarInput {

    ITipoUnidadRepository miTipoUnidadRepository;

    public TipoUnidadModificarUseCase(ITipoUnidadRepository miTipoUnidadRepository) { this.miTipoUnidadRepository = miTipoUnidadRepository; }

    @Override
    public boolean modificarTipoUnidad(TipoUnidad unTipoUnidad) throws TipoUnidadExisteException {
        if(miTipoUnidadRepository.existeTipoUnidad(unTipoUnidad.getNombre())){
            throw new TipoUnidadExisteException();
        }
        return miTipoUnidadRepository.guardarTipoUnidad(unTipoUnidad);
    }
}
