package com.ar.genesis.sistema.tipounidad.core.repository;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;

import java.util.List;

public interface ITipoUnidadObtenerRepository {
    List<TipoUnidad> obtenerTipoUnidades();
}
