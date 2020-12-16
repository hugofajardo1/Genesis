package com.ar.genesis.sistema.tipomovimiento.core.repository;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;

public interface ITipoMovimientoRepository {
    boolean existeTipoMovimiento(String nombre);

    boolean guardarTipoMovimiento(TipoMovimiento unTipoMovimiento);
}
