package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.input.ITipoMovimientoObtenerInput;
import com.ar.genesis.sistema.core.repository.ITipoMovimientoObtenerRepository;
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
