package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.TipoFicha;

public interface ITipoFichaRepository {
    boolean existeTipoCliente(String nombre);

    boolean guardarTipoCliente(TipoFicha unCliente);
}
