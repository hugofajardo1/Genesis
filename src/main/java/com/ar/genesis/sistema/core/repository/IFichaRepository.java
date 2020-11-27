package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Ficha;

public interface IFichaRepository {

    boolean existeFicha(String nombre);

    boolean guardarFicha(Ficha ficha);
}
