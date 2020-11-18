package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.TipoFicha;

public interface ITipoFichaRepository {
    boolean existeTipoFicha(String nombre);

    boolean guardarTipoFicha(TipoFicha unTipoFicha);
}
