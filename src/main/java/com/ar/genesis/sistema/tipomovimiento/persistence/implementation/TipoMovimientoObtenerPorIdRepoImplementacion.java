package com.ar.genesis.sistema.tipomovimiento.persistence.implementation;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.repository.ITipoMovimientoObtenerPorIdRepository;
import com.ar.genesis.sistema.tipomovimiento.persistence.crud.ITipoMovimientoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoMovimientoObtenerPorIdRepoImplementacion implements ITipoMovimientoObtenerPorIdRepository {
    @Inject
    ITipoMovimientoCRUD miTipoMovimientoCRUD;

    @Override
    public TipoMovimiento obtenerTipoMovimiento(Integer id) { return miTipoMovimientoCRUD.findTipoMovimientoByIdEquals(id); }
}
