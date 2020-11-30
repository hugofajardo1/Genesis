package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.exception.FichaExisteException;

public interface IFichaCrearInput {

    boolean crearFicha(Ficha ficha) throws FichaExisteException;
}
