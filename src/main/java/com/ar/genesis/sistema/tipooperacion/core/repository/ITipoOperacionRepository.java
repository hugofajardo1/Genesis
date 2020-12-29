package com.ar.genesis.sistema.tipooperacion.core.repository;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;

public interface ITipoOperacionRepository {
    boolean existeTipoOperacion(String nombre);

    boolean guardarTipoOperacion(TipoOperacion unTipoOperacion);
}
