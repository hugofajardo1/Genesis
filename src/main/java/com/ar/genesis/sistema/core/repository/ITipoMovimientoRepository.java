package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;

public interface ITipoMovimientoRepository {
    boolean existeTipoMovimiento(String nombre);

    boolean guardarTipoMovimiento(TipoMovimiento unTipoMovimiento);
}
