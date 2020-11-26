package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;

import java.util.List;

public interface IObtenerTipoMovimientosRepository {
    List<TipoMovimiento> obtenerTipoMovimientos();
}
