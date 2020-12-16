package com.ar.genesis.sistema.ubicacion.core.input;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.exception.UbicacionNoExisteException;

public interface IUbicacionObtenerPorIdInput {
    Ubicacion obtenerUbicacion(Integer id) throws UbicacionNoExisteException;
}
