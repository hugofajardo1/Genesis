package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoExisteException;

public interface IModificarTipoMovimientoInput {
    boolean modificarTipoMovimiento(TipoMovimiento unTipoMovimiento) throws TipoMovimientoExisteException;
}
