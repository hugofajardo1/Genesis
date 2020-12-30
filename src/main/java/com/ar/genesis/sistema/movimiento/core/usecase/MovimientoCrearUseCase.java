package com.ar.genesis.sistema.movimiento.core.usecase;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.exception.MovimientoIncompletoException;
import com.ar.genesis.sistema.movimiento.core.input.IMovimientoCrearInput;
import com.ar.genesis.sistema.movimiento.core.repository.IMovimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovimientoCrearUseCase implements IMovimientoCrearInput {

    IMovimientoRepository miMovimientoRepository;

    public MovimientoCrearUseCase(IMovimientoRepository miMovimientoRepository) {
        this.miMovimientoRepository = miMovimientoRepository;
    }

    @Override
    public Movimiento crearMovimiento(Movimiento unMovimiento) throws MovimientoIncompletoException {
        if(unMovimiento.getItems().isEmpty()){
            throw new MovimientoIncompletoException();
        }
        return miMovimientoRepository.guardarMovimiento(unMovimiento);
    }
}
