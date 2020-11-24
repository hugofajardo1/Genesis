package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;

public interface IModificarUbicacionInput {
    boolean modificarUbicacion(Ubicacion unUbicacion) throws UbicacionExisteException;
}
