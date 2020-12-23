package com.ar.genesis.sistema.movimiento.core.input;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.exception.MovimientoNoExisteException;

public interface IMovimientoObtenerPorIdInput {
    Movimiento obtenerMovimiento(Integer id) throws MovimientoNoExisteException;
}
