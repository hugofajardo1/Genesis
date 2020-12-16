package com.ar.genesis.sistema.movimiento.core.repository;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;

public interface IMovimientoRepository {
    boolean guardarMovimiento(Movimiento unMovimiento);
}
