package com.ar.genesis.sistema.movimiento.persistence.implementation;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.repository.IMovimientoObtenerEntreFechasRepository;
import com.ar.genesis.sistema.movimiento.persistence.crud.IMovimientoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovimientoObtenerEntreFechasRepoImplementacion implements IMovimientoObtenerEntreFechasRepository {
    @Inject
    IMovimientoCRUD miMovimientoCRUD;

    @Override
    public List<Movimiento> obtenerMovimientosEntreFechas(LocalDate fechaDesde, LocalDate fechaHasta) {  return miMovimientoCRUD.findAllByFechaBetween(fechaDesde, fechaHasta); }
}