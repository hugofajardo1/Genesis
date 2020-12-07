package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;

public interface ITipoMovimientoObtenerPorIdRepository {
    TipoMovimiento obtenerTipoMovimiento(Integer id);
}
