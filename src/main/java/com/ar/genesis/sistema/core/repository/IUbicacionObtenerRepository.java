package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Ubicacion;

import java.util.List;

public interface IUbicacionObtenerRepository {
    List<Ubicacion> obtenerUbicaciones();
}