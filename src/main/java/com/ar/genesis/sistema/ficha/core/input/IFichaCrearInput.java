package com.ar.genesis.sistema.ficha.core.input;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.exception.FichaExisteException;

public interface IFichaCrearInput {

    boolean crearFicha(Ficha ficha) throws FichaExisteException;
}
