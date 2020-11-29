package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.repository.IFichaRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class FichaRepoImplementacion implements IFichaRepository {

    @Inject
    IFichaCRUD miFichaCRUD;

    @Override
    public boolean existeFicha(String nombre) {
        return miFichaCRUD.existsByNombre(nombre);
    }

    @Override
    public boolean guardarFicha(Ficha ficha) {
        return miFichaCRUD.save(ficha).getId()!=null;
    }
}