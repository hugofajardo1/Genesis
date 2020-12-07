package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionNoExisteException;

public interface IUbicacionObtenerPorIdInput {
    Ubicacion obtenerUbicacion(Integer id) throws UbicacionNoExisteException;
}
