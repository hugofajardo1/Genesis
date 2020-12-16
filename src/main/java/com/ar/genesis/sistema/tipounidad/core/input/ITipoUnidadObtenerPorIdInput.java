package com.ar.genesis.sistema.tipounidad.core.input;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.core.exception.TipoUnidadNoExisteException;

public interface ITipoUnidadObtenerPorIdInput {
    TipoUnidad obtenerTipoUnidad(Integer id) throws TipoUnidadNoExisteException;
}
