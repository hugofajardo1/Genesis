package com.ar.genesis.sistema.tipomovimiento.core.input;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.exception.TipoMovimientoNoExisteException;

public interface ITipoMovimientoObtenerPorIdInput {
    TipoMovimiento obtenerTipoMovimiento(Integer id) throws TipoMovimientoNoExisteException;
}
