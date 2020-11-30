package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.repository.ITipoUnidadObtenerRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoUnidadCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TipoUnidadObtenerRepoImplmentacion implements ITipoUnidadObtenerRepository {
    @Inject
    ITipoUnidadCRUD miTipoUnidadCRUD;

    @Override
    public List<TipoUnidad> obtenerTipoUnidades() {
        return miTipoUnidadCRUD.findAllByOrderById();
    }
}
