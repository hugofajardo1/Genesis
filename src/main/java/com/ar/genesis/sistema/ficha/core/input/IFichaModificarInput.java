package com.ar.genesis.sistema.ficha.core.input;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.exception.FichaExisteException;

public interface IFichaModificarInput {
    boolean modificarFicha(Ficha ficha) throws FichaExisteException;
}
