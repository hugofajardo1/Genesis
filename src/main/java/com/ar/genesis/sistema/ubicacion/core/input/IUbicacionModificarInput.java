package com.ar.genesis.sistema.ubicacion.core.input;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.exception.UbicacionExisteException;

public interface IUbicacionModificarInput {
    boolean modificarUbicacion(Ubicacion unaUbicacion) throws UbicacionExisteException;
}
