package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.TipoUnidad;

public interface ITipoUnidadRepository {
    boolean existeTipoUnidad(String nombre);

    boolean guardarTipoUnidad(TipoUnidad unTipoUnidad);
}
