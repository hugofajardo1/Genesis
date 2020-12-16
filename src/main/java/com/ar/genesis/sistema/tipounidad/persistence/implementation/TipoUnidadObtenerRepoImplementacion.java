package com.ar.genesis.sistema.tipounidad.persistence.implementation;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.core.repository.ITipoUnidadObtenerRepository;
import com.ar.genesis.sistema.tipounidad.persistence.crud.ITipoUnidadCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TipoUnidadObtenerRepoImplementacion implements ITipoUnidadObtenerRepository {
    @Inject
    ITipoUnidadCRUD miTipoUnidadCRUD;

    @Override
    public List<TipoUnidad> obtenerTipoUnidades() {
        return miTipoUnidadCRUD.findAllByOrderById();
    }
}
