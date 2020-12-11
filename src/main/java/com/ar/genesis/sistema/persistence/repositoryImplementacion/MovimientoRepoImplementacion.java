package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Movimiento;
import com.ar.genesis.sistema.core.repository.IMovimientoRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IMovimientoCRUD;
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
