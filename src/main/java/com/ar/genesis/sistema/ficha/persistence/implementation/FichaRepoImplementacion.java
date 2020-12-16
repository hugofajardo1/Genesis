package com.ar.genesis.sistema.ficha.persistence.implementation;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.repository.IFichaRepository;
import com.ar.genesis.sistema.ficha.persistence.crud.IFichaCRUD;
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
    public boolean guardarFicha(Ficha unaFicha) {
        return miFichaCRUD.save(unaFicha).getId()!=null;
    }
}