package com.ar.genesis.sistema.tipomovimiento.persistence.implementation;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.repository.ITipoMovimientoRepository;
import com.ar.genesis.sistema.tipomovimiento.persistence.crud.ITipoMovimientoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoMovimientoRepoImplementacion implements ITipoMovimientoRepository {

    @Inject
    ITipoMovimientoCRUD miTipoMovimientoCRUD;

    @Override
    public boolean existeTipoMovimiento(String nombre) { return miTipoMovimientoCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarTipoMovimiento(TipoMovimiento unTipoMovimiento) { return miTipoMovimientoCRUD.save(unTipoMovimiento).getId()!=null; }
}
