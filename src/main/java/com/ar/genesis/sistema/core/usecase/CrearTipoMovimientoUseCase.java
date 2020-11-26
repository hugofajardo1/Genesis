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

    ITipoMovimientoRepository iTipoMovimientoRepository;

    public CrearTipoMovimientoUseCase(ITipoMovimientoRepository iTipoMovimientoRepository) {
        this.iTipoMovimientoRepository = iTipoMovimientoRepository;
    }

    public boolean crearTipoMovimiento(TipoMovimiento tipoMovimientoNueva) throws TipoMovimientoExisteException {
        if (iTipoMovimientoRepository.existeTipoMovimiento(tipoMovimientoNueva.getNombre())){
            throw new TipoMovimientoExisteException();
        }
        return iTipoMovimientoRepository.guardarTipoMovimiento(tipoMovimientoNueva);
    }
}
