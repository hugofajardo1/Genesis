package com.ar.genesis.sistema.tipomovimiento.persistence.implementation;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.repository.ITipoMovimientoObtenerRepository;
import com.ar.genesis.sistema.tipomovimiento.persistence.crud.ITipoMovimientoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TipoMovimientoObtenerRepoImplementacion implements ITipoMovimientoObtenerRepository {
    @Inject
    ITipoMovimientoCRUD miTipoMovimientoCRUD;

    @Override
    public List<TipoMovimiento> obtenerTipoMovimientos() {
        return miTipoMovimientoCRUD.findAllByOrderById();
    }
}
