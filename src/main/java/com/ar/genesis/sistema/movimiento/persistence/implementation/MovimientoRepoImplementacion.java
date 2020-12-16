package com.ar.genesis.sistema.movimiento.persistence.implementation;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.repository.IMovimientoRepository;
import com.ar.genesis.sistema.movimiento.persistence.crud.IMovimientoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MovimientoRepoImplementacion implements IMovimientoRepository {

    @Inject
    IMovimientoCRUD miMovimientoCRUD;

    @Override
    public boolean guardarMovimiento(Movimiento unMovimiento) {
        return miMovimientoCRUD.save(unMovimiento).getId()!=null; }
}
