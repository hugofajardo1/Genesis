package com.ar.genesis.sistema.ficha.core.repository;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;

public interface IFichaRepository {

    boolean existeFicha(String nombre);

    boolean guardarFicha(Ficha ficha);
}
