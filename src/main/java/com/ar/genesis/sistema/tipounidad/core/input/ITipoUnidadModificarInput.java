package com.ar.genesis.sistema.tipounidad.core.input;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.core.exception.TipoUnidadExisteException;

public interface ITipoUnidadModificarInput {
    boolean modificarTipoUnidad(TipoUnidad unTipoUnidad) throws TipoUnidadExisteException;
}
