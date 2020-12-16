package com.ar.genesis.sistema.ficha.core.repository;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;

public interface IFichaObtenerPorIdRepository {
    Ficha obtenerFicha(Integer id);
}
