package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Ficha;

public interface IFichaObtenerPorIdRepository {
    Ficha obtenerFicha(Integer id);
}
