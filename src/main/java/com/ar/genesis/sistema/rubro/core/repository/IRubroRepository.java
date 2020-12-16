package com.ar.genesis.sistema.rubro.core.repository;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;

public interface IRubroRepository {
    boolean existeRubro(String nombre);

    boolean guardarRubro(Rubro unRubro);
}
