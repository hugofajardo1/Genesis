package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.SubRubro;

public interface ISubRubroRepository {
    boolean existeSubRubro(String nombre);

    boolean guardarSubRubro(SubRubro unSubRubro);
}
