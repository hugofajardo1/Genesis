package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.repository.ITipoMovimientoObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoMovimientoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoMovimientoObtenerPorIdRepoImplementacion implements ITipoMovimientoObtenerPorIdRepository {
    @Inject
    ITipoMovimientoCRUD miTipoMovimientoCRUD;

    @Override
    public TipoMovimiento obtenerTipoMovimiento(Integer id) { return miTipoMovimientoCRUD.findTipoMovimientoByIdEquals(id); }
}
