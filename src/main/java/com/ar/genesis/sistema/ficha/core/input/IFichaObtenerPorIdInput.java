package com.ar.genesis.sistema.ficha.core.input;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.exception.FichaNoExisteException;

public interface IFichaObtenerPorIdInput {
    Ficha obtenerFicha(Integer id) throws FichaNoExisteException;
}
