package com.ar.genesis.sistema.movimiento.persistence.implementation;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.repository.IMovimientoObtenerPorIdRepository;
import com.ar.genesis.sistema.movimiento.persistence.crud.IMovimientoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MovimientoObtenerPorIdRepoImplementacion implements IMovimientoObtenerPorIdRepository {
    @Inject
    IMovimientoCRUD miMovimientoCRUD;

    @Override
    public Movimiento obtenerMovimiento(Integer id) { return miMovimientoCRUD.findMovimientoByIdEquals(id); }
}
