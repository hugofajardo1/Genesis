package com.ar.genesis.sistema.tipoiva.core.usecase;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.exception.TipoIvaNoExisteException;
import com.ar.genesis.sistema.tipoiva.core.input.ITipoIvaObtenerPorIdInput;
import com.ar.genesis.sistema.tipoiva.core.repository.ITipoIvaObtenerPorIdRepository;
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
