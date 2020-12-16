package com.ar.genesis.sistema.localidad.core.repository;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;

public interface ILocalidadObtenerPorIdRepository {
    Localidad obtenerLocalidad(Integer id);
}
