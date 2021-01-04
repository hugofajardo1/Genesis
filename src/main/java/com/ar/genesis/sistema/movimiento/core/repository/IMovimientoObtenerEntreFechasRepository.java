package com.ar.genesis.sistema.movimiento.core.repository;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;

import java.time.LocalDate;
import java.util.List;

public interface IMovimientoObtenerEntreFechasRepository {
    List<Movimiento> obtenerMovimientosEntreFechas(LocalDate fechaDesde, LocalDate fechaHasta);
}
