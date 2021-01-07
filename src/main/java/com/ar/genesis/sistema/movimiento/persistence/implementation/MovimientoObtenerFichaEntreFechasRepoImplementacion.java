package com.ar.genesis.sistema.movimiento.persistence.implementation;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.repository.IMovimientoObtenerFichaEntreFechasRepository;
import com.ar.genesis.sistema.movimiento.persistence.crud.IMovimientoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovimientoObtenerFichaEntreFechasRepoImplementacion implements IMovimientoObtenerFichaEntreFechasRepository {
    @Inject
    IMovimientoCRUD miMovimientoCRUD;

    @Override
    public List<Movimiento> obtenerMovimientosFichaEntreFechas(Ficha unaFicha, LocalDate fechaDesde, LocalDate fechaHasta) {  return miMovimientoCRUD.findAllByFichaAndFechaBetween(unaFicha, fechaDesde, fechaHasta); }
}