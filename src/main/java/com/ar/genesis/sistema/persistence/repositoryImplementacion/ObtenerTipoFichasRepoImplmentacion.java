package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.repository.IObtenerTipoFichasRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ObtenerTipoFichasRepoImplmentacion implements IObtenerTipoFichasRepository {
    @Inject
    ITipoFichaCRUD tipoFichaCRUD;

    @Override
    public List<TipoFicha> obtenerTipoFichas() {
        return tipoFichaCRUD.findAllByOrderById();
    }
}
