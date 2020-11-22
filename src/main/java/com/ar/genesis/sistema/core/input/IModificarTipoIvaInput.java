package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;

public interface IModificarTipoIvaInput {
    boolean modificarTipoIva(TipoIva unTipoIva) throws TipoIvaExisteException;
}