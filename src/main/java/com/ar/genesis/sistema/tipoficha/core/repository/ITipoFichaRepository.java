package com.ar.genesis.sistema.tipoficha.core.repository;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;

public interface ITipoFichaRepository {
    boolean existeTipoFicha(String nombre);

    boolean guardarTipoFicha(TipoFicha unTipoFicha);
}
