package com.ar.genesis.sistema.movimiento.core.usecase;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.input.IMovimientoObtenerEntreFechasInput;
import com.ar.genesis.sistema.movimiento.core.repository.IMovimientoObtenerEntreFechasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MovimientoObtenerEntreFechasUseCase implements IMovimientoObtenerEntreFechasInput {

    IMovimientoObtenerEntreFechasRepository miMovimientoObtenerEntreFechasRepository;

    public MovimientoObtenerEntreFechasUseCase(IMovimientoObtenerEntreFechasRepository miMovimientoObtenerEntreFechasRepository) { this.miMovimientoObtenerEntreFechasRepository = miMovimientoObtenerEntreFechasRepository; }

    @Override
    public List<Movimiento> obtenerMovimientosEntreFechas(LocalDate fechaDesde, LocalDate fechaHasta) {
        return miMovimientoObtenerEntreFechasRepository.obtenerMovimientosEntreFechas(fechaDesde, fechaHasta);
    }
}
