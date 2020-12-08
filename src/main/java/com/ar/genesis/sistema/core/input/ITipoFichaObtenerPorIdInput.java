package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaNoExisteException;

public interface ITipoFichaObtenerPorIdInput {
    TipoFicha obtenerTipoFicha(Integer id) throws TipoFichaNoExisteException;
}
