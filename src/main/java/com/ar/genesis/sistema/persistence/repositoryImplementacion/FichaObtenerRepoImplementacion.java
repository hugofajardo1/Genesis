package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.repository.IObtenerFichasRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class FichaObtenerRepoImplementacion implements IObtenerFichasRepository {
    @Inject
    IFichaCRUD miFichaCRUD;

    @Override
    public List<Ficha> obtenerFichas() {
        return miFichaCRUD.findAllByOrderById();
    }
}
