package com.ar.genesis.sistema.tipounidad.core.repository;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;

public interface ITipoUnidadRepository {
    boolean existeTipoUnidad(String nombre);

    boolean guardarTipoUnidad(TipoUnidad unTipoUnidad);
}
