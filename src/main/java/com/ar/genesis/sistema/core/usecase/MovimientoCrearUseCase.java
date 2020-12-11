package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Movimiento;
import com.ar.genesis.sistema.core.exception.MovimientoIncompletoException;
import com.ar.genesis.sistema.core.input.IMovimientoCrearInput;
import com.ar.genesis.sistema.core.repository.IMovimientoRepository;
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
    public boolean crearMovimiento(Movimiento unMovimiento) throws MovimientoIncompletoException {
        if(unMovimiento.getItems().isEmpty()){
            throw new MovimientoIncompletoException();
        }
        return miMovimientoRepository.guardarMovimiento(unMovimiento);
    }
}
