package com.ar.genesis.sistema.tipooperacion.core.input;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionExisteException;

public interface ITipoOperacionModificarInput {
    boolean modificarTipoOperacion(TipoOperacion unTipoOperacion) throws TipoOperacionExisteException;
}
