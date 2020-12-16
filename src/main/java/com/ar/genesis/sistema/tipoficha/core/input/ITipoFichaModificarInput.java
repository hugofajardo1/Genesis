package com.ar.genesis.sistema.tipoficha.core.input;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.exception.TipoFichaExisteException;

public interface ITipoFichaModificarInput {

    boolean modificarTipoFicha(TipoFicha unTipoFicha) throws TipoFichaExisteException;
}
