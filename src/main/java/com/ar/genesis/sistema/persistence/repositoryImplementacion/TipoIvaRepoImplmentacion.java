package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.repository.ITipoIvaObtenerRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoIvaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TipoIvaRepoImplmentacion implements ITipoIvaObtenerRepository {
    @Inject
    ITipoIvaCRUD miTipoIvaCRUD;

    @Override
    public List<TipoIva> obtenerTipoIvas() {
        return miTipoIvaCRUD.findAllByOrderById();
    }
}
