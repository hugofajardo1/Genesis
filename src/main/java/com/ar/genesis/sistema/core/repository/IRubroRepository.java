package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Rubro;

public interface IRubroRepository {
    boolean existeRubro(String nombre);

    boolean guardarRubro(Rubro unRubro);
}
