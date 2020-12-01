package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadExisteException;

public interface ITipoUnidadCrearInput {

    boolean crearTipoUnidad(TipoUnidad unTipoUnidad) throws TipoUnidadExisteException;
}