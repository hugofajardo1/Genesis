package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.repository.ITipoMovimientoObtenerRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoMovimientoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TipoMovimientoRepoImplmentacion implements ITipoMovimientoObtenerRepository {
    @Inject
    ITipoMovimientoCRUD miTipoMovimientoCRUD;

    @Override
    public List<TipoMovimiento> obtenerTipoMovimientos() {
        return miTipoMovimientoCRUD.findAllByOrderById();
    }
}
