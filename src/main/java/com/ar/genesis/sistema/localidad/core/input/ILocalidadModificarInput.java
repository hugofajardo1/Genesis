package com.ar.genesis.sistema.localidad.core.input;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.exception.LocalidadExisteException;

public interface ILocalidadModificarInput {
    boolean modificarLocalidad(Localidad unaLocalidad) throws LocalidadExisteException;
}
