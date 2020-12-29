package com.ar.genesis.sistema.tipooperacion.core.input;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionNoExisteException;

public interface ITipoOperacionObtenerPorIdInput {
    TipoOperacion obtenerTipoOperacion(Integer id) throws TipoOperacionNoExisteException;
}
