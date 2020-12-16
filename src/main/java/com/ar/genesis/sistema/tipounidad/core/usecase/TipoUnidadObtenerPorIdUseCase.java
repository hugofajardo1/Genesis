package com.ar.genesis.sistema.tipounidad.core.usecase;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.core.exception.TipoUnidadNoExisteException;
import com.ar.genesis.sistema.tipounidad.core.input.ITipoUnidadObtenerPorIdInput;
import com.ar.genesis.sistema.tipounidad.core.repository.ITipoUnidadObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoUnidadObtenerPorIdUseCase implements ITipoUnidadObtenerPorIdInput {

    ITipoUnidadObtenerPorIdRepository miTipoUnidadObtenerPorIdRepository;

    public TipoUnidadObtenerPorIdUseCase(ITipoUnidadObtenerPorIdRepository miTipoUnidadObtenerPorIdRepository) { this.miTipoUnidadObtenerPorIdRepository = miTipoUnidadObtenerPorIdRepository; }

    @Override
    public TipoUnidad obtenerTipoUnidad(Integer id) throws TipoUnidadNoExisteException {
        TipoUnidad unTipoUnidad = miTipoUnidadObtenerPorIdRepository.obtenerTipoUnidad(id);
        if(unTipoUnidad==null){
            throw new TipoUnidadNoExisteException();
        }
        return unTipoUnidad;
    }
}
