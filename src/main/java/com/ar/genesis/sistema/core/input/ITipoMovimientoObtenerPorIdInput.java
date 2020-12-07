package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoNoExisteException;

public interface ITipoMovimientoObtenerPorIdInput {
    TipoMovimiento obtenerTipoMovimiento(Integer id) throws TipoMovimientoNoExisteException;
}
