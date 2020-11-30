package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadExisteException;

public interface ILocalidadModificarInput {
    boolean modificarLocalidad(Localidad unaLocalidad) throws LocalidadExisteException;
}
