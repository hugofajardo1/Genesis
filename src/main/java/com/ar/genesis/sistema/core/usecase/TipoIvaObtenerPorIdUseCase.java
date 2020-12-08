package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaNoExisteException;
import com.ar.genesis.sistema.core.input.ITipoIvaObtenerPorIdInput;
import com.ar.genesis.sistema.core.repository.ITipoIvaObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoIvaObtenerPorIdUseCase implements ITipoIvaObtenerPorIdInput {

    ITipoIvaObtenerPorIdRepository miTipoIvaObtenerPorIdRepository;

    public TipoIvaObtenerPorIdUseCase(ITipoIvaObtenerPorIdRepository miTipoIvaObtenerPorIdRepository) { this.miTipoIvaObtenerPorIdRepository = miTipoIvaObtenerPorIdRepository; }

    @Override
    public TipoIva obtenerTipoIva(Integer id) throws TipoIvaNoExisteException {
        TipoIva unTipoIva = miTipoIvaObtenerPorIdRepository.obtenerTipoIva(id);
        if(unTipoIva==null){
            throw new TipoIvaNoExisteException();
        }
        return unTipoIva;
    }
}
