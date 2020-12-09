package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.repository.IFichaObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class FichaObtenerPorIdRepoImplementacion implements IFichaObtenerPorIdRepository {
    @Inject
    IFichaCRUD miFichaCRUD;

    @Override
    public Ficha obtenerFicha(Integer id) { return miFichaCRUD.findFichaByIdEquals(id); }
}
