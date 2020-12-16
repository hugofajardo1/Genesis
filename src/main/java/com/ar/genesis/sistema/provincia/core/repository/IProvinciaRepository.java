package com.ar.genesis.sistema.provincia.core.repository;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;

public interface IProvinciaRepository {
    boolean existeProvincia(String nombre);

    boolean guardarProvincia(Provincia unaProvincia);
}
