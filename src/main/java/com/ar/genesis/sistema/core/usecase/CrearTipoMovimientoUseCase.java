package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoMovimientoInput;
import com.ar.genesis.sistema.core.repository.ITipoMovimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrearTipoMovimientoUseCase implements ICrearTipoMovimientoInput {

    ITipoMovimientoRepository miTipoMovimientoRepository;

    public CrearTipoMovimientoUseCase(ITipoMovimientoRepository miTipoMovimientoRepository) {  this.miTipoMovimientoRepository = miTipoMovimientoRepository; }

    public boolean crearTipoMovimiento(TipoMovimiento unTipoMovimiento) throws TipoMovimientoExisteException {
        if (miTipoMovimientoRepository.existeTipoMovimiento(unTipoMovimiento.getNombre())){
            throw new TipoMovimientoExisteException();
        }
        return miTipoMovimientoRepository.guardarTipoMovimiento(unTipoMovimiento);
    }
}
