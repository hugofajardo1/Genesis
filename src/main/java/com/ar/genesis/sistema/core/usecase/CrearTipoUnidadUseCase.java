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

    ITipoUnidadRepository iTipoUnidadRepository;

    public CrearTipoUnidadUseCase(ITipoUnidadRepository iTipoUnidadRepository) {
        this.iTipoUnidadRepository = iTipoUnidadRepository;
    }

    public boolean crearTipoUnidad(TipoUnidad tipoUnidadNueva) throws TipoUnidadExisteException {
        if (iTipoUnidadRepository.existeTipoUnidad(tipoUnidadNueva.getNombre())){
            throw new TipoUnidadExisteException();
        }
        return iTipoUnidadRepository.guardarTipoUnidad(tipoUnidadNueva);
    }
}
