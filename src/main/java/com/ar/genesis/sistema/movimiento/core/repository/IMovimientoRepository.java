package com.ar.genesis.sistema.movimiento.core.repository;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;

public interface IMovimientoRepository {
    Movimiento guardarMovimiento(Movimiento unMovimiento);
}
