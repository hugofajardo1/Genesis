package com.ar.genesis.sistema.tipoficha.core.repository;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;

import java.util.List;

public interface ITipoFichaObtenerRepository {
    List<TipoFicha> obtenerTipoFichas();
}
