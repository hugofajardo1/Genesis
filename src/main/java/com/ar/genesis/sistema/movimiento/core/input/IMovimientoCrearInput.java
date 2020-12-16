package com.ar.genesis.sistema.movimiento.core.input;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.exception.MovimientoExisteException;
import com.ar.genesis.sistema.movimiento.core.exception.MovimientoIncompletoException;

public interface IMovimientoCrearInput {
    boolean crearMovimiento(Movimiento unMovimiento) throws MovimientoExisteException, MovimientoIncompletoException;
}
