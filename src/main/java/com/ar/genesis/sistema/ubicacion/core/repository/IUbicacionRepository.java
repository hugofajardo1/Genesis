package com.ar.genesis.sistema.ubicacion.core.repository;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;

public interface IUbicacionRepository {
    boolean existeUbicacion(String nombre);

    boolean guardarUbicacion(Ubicacion ubicacion);
}
