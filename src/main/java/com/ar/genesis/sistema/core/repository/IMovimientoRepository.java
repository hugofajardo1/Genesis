package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Movimiento;

public interface IMovimientoRepository {
    boolean guardarMovimiento(Movimiento unMovimiento);
}
