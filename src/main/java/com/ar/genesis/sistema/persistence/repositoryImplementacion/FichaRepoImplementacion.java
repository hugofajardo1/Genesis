package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.repository.IFichaRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class FichaRepoImplementacion implements IFichaRepository {

    @Inject
    IFichaCRUD fichaCRUD;

    @Override
    public boolean existeFicha(String nombre) {
        return fichaCRUD.existsByNombre(nombre);
    }

    @Override
    public boolean guardarFicha(Ficha ficha) {
        return fichaCRUD.save(ficha).getId()!=null;
    }
}