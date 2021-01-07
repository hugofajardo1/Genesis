package com.ar.genesis.sistema.movimiento.core.usecase;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.repository.IFichaObtenerPorIdRepository;
import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.input.IMovimientoObtenerFichaEntreFechasInput;
import com.ar.genesis.sistema.movimiento.core.repository.IMovimientoObtenerFichaEntreFechasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class MovimientoObtenerFichaEntreFechasUseCase implements IMovimientoObtenerFichaEntreFechasInput {

    IMovimientoObtenerFichaEntreFechasRepository miMovimientoObtenerFichaEntreFechasRepository;

    public MovimientoObtenerFichaEntreFechasUseCase(IMovimientoObtenerFichaEntreFechasRepository miMovimientoObtenerFichaEntreFechasRepository) {
        this.miMovimientoObtenerFichaEntreFechasRepository = miMovimientoObtenerFichaEntreFechasRepository;
    }

    @Override
    public List<Movimiento> obtenerMovimientosFichaEntreFechas(Ficha unaFicha, LocalDate fechaDesde, LocalDate fechaHasta) {
        return miMovimientoObtenerFichaEntreFechasRepository.obtenerMovimientosFichaEntreFechas(unaFicha, fechaDesde, fechaHasta);
    }
}