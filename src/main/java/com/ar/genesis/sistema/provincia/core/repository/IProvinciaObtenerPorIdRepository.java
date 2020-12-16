package com.ar.genesis.sistema.provincia.core.repository;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;

public interface IProvinciaObtenerPorIdRepository {
    Provincia obtenerProvincia(Integer id);
}
