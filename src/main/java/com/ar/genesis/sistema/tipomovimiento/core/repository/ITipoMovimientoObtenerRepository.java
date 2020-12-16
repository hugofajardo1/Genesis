package com.ar.genesis.sistema.tipomovimiento.core.repository;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;

import java.util.List;

public interface ITipoMovimientoObtenerRepository {
    List<TipoMovimiento> obtenerTipoMovimientos();
}
