package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.exception.FichaExisteException;

public interface IModificarFichaInput {
    boolean modificarFicha(Ficha ficha) throws FichaExisteException;
}
