package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.exception.FichaNoExisteException;

public interface IFichaObtenerPorIdInput {
    Ficha obtenerFicha(Integer id) throws FichaNoExisteException;
}
