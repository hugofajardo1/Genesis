package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.input.IObtenerTipoMovimientosInput;
import com.ar.genesis.sistema.core.repository.IObtenerTipoMovimientosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObtenerTipoMovimientosUseCase implements IObtenerTipoMovimientosInput {

    IObtenerTipoMovimientosRepository miObtenerTipoMovimientosRepository;

    public ObtenerTipoMovimientosUseCase(IObtenerTipoMovimientosRepository miObtenerTipoMovimientosRepository) { this.miObtenerTipoMovimientosRepository = miObtenerTipoMovimientosRepository; }

    @Override
    public List<TipoMovimiento> obtenerTipoMovimientos() {
        return miObtenerTipoMovimientosRepository.obtenerTipoMovimientos();
    }
}
