package com.ar.genesis.sistema.tipomovimiento.core.usecase;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.tipomovimiento.core.input.ITipoMovimientoCrearInput;
import com.ar.genesis.sistema.tipomovimiento.core.repository.ITipoMovimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoMovimientoCrearUseCase implements ITipoMovimientoCrearInput {

    ITipoMovimientoRepository miTipoMovimientoRepository;

    public TipoMovimientoCrearUseCase(ITipoMovimientoRepository miTipoMovimientoRepository) {  this.miTipoMovimientoRepository = miTipoMovimientoRepository; }

    public boolean crearTipoMovimiento(TipoMovimiento unTipoMovimiento) throws TipoMovimientoExisteException {
        if (miTipoMovimientoRepository.existeTipoMovimiento(unTipoMovimiento.getNombre())){
            throw new TipoMovimientoExisteException();
        }
        return miTipoMovimientoRepository.guardarTipoMovimiento(unTipoMovimiento);
    }
}
