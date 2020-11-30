package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;

public interface IUbicacionModificarInput {
    boolean modificarUbicacion(Ubicacion unaUbicacion) throws UbicacionExisteException;
}
