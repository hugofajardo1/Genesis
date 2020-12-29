package com.ar.genesis.sistema.tipooperacion.persistence.implementation;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.repository.ITipoOperacionObtenerRepository;
import com.ar.genesis.sistema.tipooperacion.persistence.crud.ITipoOperacionCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TipoOperacionObtenerRepoImplementacion implements ITipoOperacionObtenerRepository {
    @Inject
    ITipoOperacionCRUD miTipoOperacionCRUD;

    @Override
    public List<TipoOperacion> obtenerTipoOperaciones() {
        return miTipoOperacionCRUD.findAllByOrderById();
    }
}
