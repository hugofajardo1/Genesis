package com.ar.genesis.sistema.subrubro.core.repository;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;

public interface ISubRubroRepository {
    boolean existeSubRubro(String nombre);

    boolean guardarSubRubro(SubRubro unSubRubro);
}
