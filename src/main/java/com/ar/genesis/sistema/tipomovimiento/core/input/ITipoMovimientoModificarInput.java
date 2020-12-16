package com.ar.genesis.sistema.tipomovimiento.core.input;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.exception.TipoMovimientoExisteException;

public interface ITipoMovimientoModificarInput {
    boolean modificarTipoMovimiento(TipoMovimiento unTipoMovimiento) throws TipoMovimientoExisteException;
}
