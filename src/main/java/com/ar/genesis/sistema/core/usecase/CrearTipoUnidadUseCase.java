package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoUnidadInput;
import com.ar.genesis.sistema.core.repository.ITipoUnidadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearTipoUnidadUseCase implements ICrearTipoUnidadInput {

    ITipoUnidadRepository miTipoUnidadRepository;

    public CrearTipoUnidadUseCase(ITipoUnidadRepository miTipoUnidadRepository) { this.miTipoUnidadRepository = miTipoUnidadRepository; }

    public boolean crearTipoUnidad(TipoUnidad unTipoUnidad) throws TipoUnidadExisteException {
        if (miTipoUnidadRepository.existeTipoUnidad(unTipoUnidad.getNombre())){
            throw new TipoUnidadExisteException();
        }
        return miTipoUnidadRepository.guardarTipoUnidad(unTipoUnidad);
    }
}
