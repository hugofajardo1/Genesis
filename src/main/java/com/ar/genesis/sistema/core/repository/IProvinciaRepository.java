package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Provincia;

public interface IProvinciaRepository {
    boolean existeProvincia(String nombre);

    boolean guardarProvincia(Provincia unaProvincia);
}
