package com.ar.genesis.sistema.tipoficha.core.input;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.exception.TipoFichaExisteException;

public interface ITipoFichaCrearInput {

    boolean crearTipoFicha(TipoFicha unTipoFicha) throws TipoFichaExisteException;
}
