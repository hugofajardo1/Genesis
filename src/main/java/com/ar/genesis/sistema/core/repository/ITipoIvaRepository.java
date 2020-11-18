package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.TipoIva;

public interface ITipoIvaRepository {
    boolean existeTipoIva(String nombre);

    boolean guardarTipoIva(TipoIva unTipoIva);
}
