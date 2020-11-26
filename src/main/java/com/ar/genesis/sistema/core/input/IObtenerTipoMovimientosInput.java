package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;

import java.util.List;

public interface IObtenerTipoMovimientosInput {
    List<TipoMovimiento> obtenerTipoMovimientos();
}
