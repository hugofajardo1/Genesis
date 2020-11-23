package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Ubicacion;

public interface IUbicacionRepository {
    boolean existeUbicacion(String nombre);

    boolean guardarUbicacion(Ubicacion unUbicacion);
}