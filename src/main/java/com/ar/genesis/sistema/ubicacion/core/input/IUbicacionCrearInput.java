package com.ar.genesis.sistema.ubicacion.core.input;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.exception.UbicacionExisteException;

public interface IUbicacionCrearInput {
    boolean crearUbicacion(Ubicacion unaUbicacion) throws UbicacionExisteException;
}
