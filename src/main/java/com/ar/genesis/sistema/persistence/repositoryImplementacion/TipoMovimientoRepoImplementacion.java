package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.repository.ITipoMovimientoRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoMovimientoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoMovimientoRepoImplementacion implements ITipoMovimientoRepository {

    @Inject
    ITipoMovimientoCRUD tipoMovimientoCRUD;

    @Override
    public boolean existeTipoMovimiento(String nombre) { return tipoMovimientoCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarTipoMovimiento(TipoMovimiento unTipoMovimiento) { return tipoMovimientoCRUD.save(unTipoMovimiento).getId()!=null; }
}
