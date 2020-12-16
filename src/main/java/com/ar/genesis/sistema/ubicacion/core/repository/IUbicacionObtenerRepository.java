package com.ar.genesis.sistema.ubicacion.core.repository;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;

import java.util.List;

public interface IUbicacionObtenerRepository {
    List<Ubicacion> obtenerUbicaciones();
}
