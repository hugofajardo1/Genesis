package com.ar.genesis.sistema.tipoficha.core.repository;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;

public interface ITipoFichaObtenerPorIdRepository {
    TipoFicha obtenerTipoFicha(Integer id);
}
