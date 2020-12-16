package com.ar.genesis.sistema.tipoiva.core.repository;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;

public interface ITipoIvaRepository {
    boolean existeTipoIva(String nombre);

    boolean guardarTipoIva(TipoIva unTipoIva);
}
