package com.ar.genesis.sistema.tipomovimiento.core.input;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;

import java.util.List;

public interface ITipoMovimientoObtenerInput {
    List<TipoMovimiento> obtenerTipoMovimientos();
}
