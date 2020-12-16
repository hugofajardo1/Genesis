package com.ar.genesis.sistema.tipomovimiento.core.usecase;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.input.ITipoMovimientoObtenerInput;
import com.ar.genesis.sistema.tipomovimiento.core.repository.ITipoMovimientoObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoMovimientoObtenerUseCase implements ITipoMovimientoObtenerInput {

    ITipoMovimientoObtenerRepository miTipoMovimientoObtenerRepository;

    public TipoMovimientoObtenerUseCase(ITipoMovimientoObtenerRepository miTipoMovimientoObtenerRepository) { this.miTipoMovimientoObtenerRepository = miTipoMovimientoObtenerRepository; }

    @Override
    public List<TipoMovimiento> obtenerTipoMovimientos() {
        return miTipoMovimientoObtenerRepository.obtenerTipoMovimientos();
    }
}
