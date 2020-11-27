package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.exception.FichaExisteException;

public interface ICrearFichaInput {

    boolean crearFicha(Ficha ficha) throws FichaExisteException;
}
