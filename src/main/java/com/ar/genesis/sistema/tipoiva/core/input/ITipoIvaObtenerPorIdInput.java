package com.ar.genesis.sistema.tipoiva.core.input;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.exception.TipoIvaNoExisteException;

public interface ITipoIvaObtenerPorIdInput {
    TipoIva obtenerTipoIva(Integer id) throws TipoIvaNoExisteException;
}
