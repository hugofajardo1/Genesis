package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.TipoFicha;

public interface ITipoFichaObtenerPorIdRepository {
    TipoFicha obtenerTipoFicha(Integer id);
}
