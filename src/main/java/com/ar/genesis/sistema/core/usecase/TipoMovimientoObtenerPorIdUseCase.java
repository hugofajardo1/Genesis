package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoNoExisteException;
import com.ar.genesis.sistema.core.input.ITipoMovimientoObtenerPorIdInput;
import com.ar.genesis.sistema.core.repository.ITipoMovimientoObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoMovimientoObtenerPorIdUseCase implements ITipoMovimientoObtenerPorIdInput {

    ITipoMovimientoObtenerPorIdRepository miTipoMovimientoObtenerPorIdRepository;

    public TipoMovimientoObtenerPorIdUseCase(ITipoMovimientoObtenerPorIdRepository miTipoMovimientoObtenerPorIdRepository) { this.miTipoMovimientoObtenerPorIdRepository = miTipoMovimientoObtenerPorIdRepository; }

    @Override
    public TipoMovimiento obtenerTipoMovimiento(Integer id) throws TipoMovimientoNoExisteException {
        TipoMovimiento unTipoMovimiento = miTipoMovimientoObtenerPorIdRepository.obtenerTipoMovimiento(id);
        if(unTipoMovimiento==null){
            throw new TipoMovimientoNoExisteException();
        }
        return unTipoMovimiento;
    }
}
