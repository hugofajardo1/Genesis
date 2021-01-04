package com.ar.genesis.sistema.movimiento.core.input;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;

import java.time.LocalDate;
import java.util.List;

public interface IMovimientoObtenerEntreFechasInput {
    List<Movimiento> obtenerMovimientosEntreFechas(LocalDate fechaDesde, LocalDate fechaHasta);
}
