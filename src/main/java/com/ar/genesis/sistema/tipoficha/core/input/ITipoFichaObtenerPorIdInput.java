package com.ar.genesis.sistema.tipoficha.core.input;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.exception.TipoFichaNoExisteException;

public interface ITipoFichaObtenerPorIdInput {
    TipoFicha obtenerTipoFicha(Integer id) throws TipoFichaNoExisteException;
}
