package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaNoExisteException;
import com.ar.genesis.sistema.core.usecase.TipoIvaObtenerPorIdUseCase;

public interface ITipoIvaObtenerPorIdInput {
    TipoIva obtenerTipoIva(Integer id) throws TipoIvaNoExisteException;
}
