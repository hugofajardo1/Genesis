package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.repository.ITipoFichaObtenerRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TipoFichaObtenerRepoImplementacion implements ITipoFichaObtenerRepository {
    @Inject
    ITipoFichaCRUD miTipoFichaCRUD;

    @Override
    public List<TipoFicha> obtenerTipoFichas() {
        return miTipoFichaCRUD.findAllByOrderById();
    }
}
