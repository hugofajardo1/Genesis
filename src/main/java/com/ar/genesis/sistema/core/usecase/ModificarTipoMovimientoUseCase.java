package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.core.input.IModificarTipoMovimientoInput;
import com.ar.genesis.sistema.core.repository.ITipoMovimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModificarTipoMovimientoUseCase implements IModificarTipoMovimientoInput {

    ITipoMovimientoRepository iTipoMovimientoRepository;

    public ModificarTipoMovimientoUseCase(ITipoMovimientoRepository iTipoMovimientoRepository) {
        this.iTipoMovimientoRepository = iTipoMovimientoRepository;
    }

    @Override
    public boolean modificarTipoMovimiento(TipoMovimiento unTipoMovimiento) throws TipoMovimientoExisteException {
        if(iTipoMovimientoRepository.existeTipoMovimiento(unTipoMovimiento.getNombre())){
            throw new TipoMovimientoExisteException();
        }
        return iTipoMovimientoRepository.guardarTipoMovimiento(unTipoMovimiento);
    }
}