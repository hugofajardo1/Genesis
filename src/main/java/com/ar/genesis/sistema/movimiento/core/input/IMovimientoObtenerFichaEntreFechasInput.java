package com.ar.genesis.sistema.movimiento.core.input;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;

import java.time.LocalDate;
import java.util.List;

public interface IMovimientoObtenerFichaEntreFechasInput {
    List<Movimiento> obtenerMovimientosFichaEntreFechas(Integer fichaid, LocalDate fechaDesde, LocalDate fechaHasta);
}
