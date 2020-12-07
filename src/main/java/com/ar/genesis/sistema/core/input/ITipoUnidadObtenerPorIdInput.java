package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadNoExisteException;

public interface ITipoUnidadObtenerPorIdInput {
    TipoUnidad obtenerTipoUnidad(Integer id) throws TipoUnidadNoExisteException;
}
