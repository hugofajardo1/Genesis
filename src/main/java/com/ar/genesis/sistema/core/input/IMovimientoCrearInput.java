package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Movimiento;
import com.ar.genesis.sistema.core.exception.MovimientoExisteException;
import com.ar.genesis.sistema.core.exception.MovimientoIncompletoException;

public interface IMovimientoCrearInput {
    boolean crearMovimiento(Movimiento unMovimiento) throws MovimientoExisteException, MovimientoIncompletoException;
}
