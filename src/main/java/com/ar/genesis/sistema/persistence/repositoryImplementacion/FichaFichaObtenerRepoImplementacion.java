package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.repository.IFichaObtenerRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class FichaFichaObtenerRepoImplementacion implements IFichaObtenerRepository {
    @Inject
    IFichaCRUD miFichaCRUD;

    @Override
    public List<Ficha> obtenerFichas() {
        return miFichaCRUD.findAllByOrderById();
    }
}
