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

    IFichaObtenerPorIdRepository miFichaObtenerPorIdRepository;

    public MovimientoObtenerFichaEntreFechasUseCase(IMovimientoObtenerFichaEntreFechasRepository miMovimientoObtenerFichaEntreFechasRepository, IFichaObtenerPorIdRepository miFichaObtenerPorIdRepository) {
        this.miMovimientoObtenerFichaEntreFechasRepository = miMovimientoObtenerFichaEntreFechasRepository;
        this.miFichaObtenerPorIdRepository = miFichaObtenerPorIdRepository;
    }

    @Override
    public List<Movimiento> obtenerMovimientosFichaEntreFechas(Integer fichaid, LocalDate fechaDesde, LocalDate fechaHasta) {
        Ficha unaFicha = miFichaObtenerPorIdRepository.obtenerFicha(fichaid);
        return miMovimientoObtenerFichaEntreFechasRepository.obtenerMovimientosFichaEntreFechas(unaFicha, fechaDesde, fechaHasta);
    }
}