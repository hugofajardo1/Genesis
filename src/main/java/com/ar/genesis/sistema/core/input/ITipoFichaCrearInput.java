package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaExisteException;

public interface ITipoFichaCrearInput {

    boolean crearTipoFicha(TipoFicha unTipoFicha) throws TipoFichaExisteException;
}
