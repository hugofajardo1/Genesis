package com.ar.genesis.sistema.localidad.core.input;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.exception.LocalidadExisteException;

public interface ILocalidadCrearInput {
    boolean crearLocalidad(Localidad localidad) throws LocalidadExisteException;
}
