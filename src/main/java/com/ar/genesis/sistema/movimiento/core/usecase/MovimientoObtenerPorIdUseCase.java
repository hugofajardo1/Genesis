package com.ar.genesis.sistema.movimiento.core.usecase;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.exception.MovimientoNoExisteException;
import com.ar.genesis.sistema.movimiento.core.input.IMovimientoObtenerPorIdInput;
import com.ar.genesis.sistema.movimiento.core.repository.IMovimientoObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovimientoObtenerPorIdUseCase implements IMovimientoObtenerPorIdInput {

    IMovimientoObtenerPorIdRepository miMovimientoObtenerPorIdRepository;

    public MovimientoObtenerPorIdUseCase(IMovimientoObtenerPorIdRepository miMovimientoObtenerPorIdRepository) { this.miMovimientoObtenerPorIdRepository = miMovimientoObtenerPorIdRepository; }

    @Override
    public Movimiento obtenerMovimiento(Integer id) throws MovimientoNoExisteException {
        Movimiento unMovimiento = miMovimientoObtenerPorIdRepository.obtenerMovimiento(id);
        if(unMovimiento==null){
            throw new MovimientoNoExisteException();
        }
        return unMovimiento;
    }
}
