package com.ar.genesis.sistema.tipomovimiento.core.repository;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;

public interface ITipoMovimientoObtenerPorIdRepository {
    TipoMovimiento obtenerTipoMovimiento(Integer id);
}
