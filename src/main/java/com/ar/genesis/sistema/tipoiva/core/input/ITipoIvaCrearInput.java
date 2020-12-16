package com.ar.genesis.sistema.tipoiva.core.input;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.exception.TipoIvaExisteException;

public interface ITipoIvaCrearInput {

    boolean crearTipoIva(TipoIva unTipoIva) throws TipoIvaExisteException;
}
