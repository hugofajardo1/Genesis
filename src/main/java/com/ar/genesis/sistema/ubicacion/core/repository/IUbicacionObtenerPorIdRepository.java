package com.ar.genesis.sistema.ubicacion.core.repository;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;

public interface IUbicacionObtenerPorIdRepository {
    Ubicacion obtenerUbicacion(Integer id);
}
