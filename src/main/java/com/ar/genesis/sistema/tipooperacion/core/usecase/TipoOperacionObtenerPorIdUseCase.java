package com.ar.genesis.sistema.tipooperacion.core.usecase;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionNoExisteException;
import com.ar.genesis.sistema.tipooperacion.core.input.ITipoOperacionObtenerPorIdInput;
import com.ar.genesis.sistema.tipooperacion.core.repository.ITipoOperacionObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoOperacionObtenerPorIdUseCase implements ITipoOperacionObtenerPorIdInput {

    ITipoOperacionObtenerPorIdRepository miTipoOperacionObtenerPorIdRepository;

    public TipoOperacionObtenerPorIdUseCase(ITipoOperacionObtenerPorIdRepository miTipoOperacionObtenerPorIdRepository) { this.miTipoOperacionObtenerPorIdRepository = miTipoOperacionObtenerPorIdRepository; }

    @Override
    public TipoOperacion obtenerTipoOperacion(Integer id) throws TipoOperacionNoExisteException {
        TipoOperacion unTipoOperacion = miTipoOperacionObtenerPorIdRepository.obtenerTipoOperacion(id);
        if(unTipoOperacion==null){
            throw new TipoOperacionNoExisteException();
        }
        return unTipoOperacion;
    }
}
