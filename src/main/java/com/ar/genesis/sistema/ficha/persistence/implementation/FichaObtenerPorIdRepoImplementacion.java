package com.ar.genesis.sistema.ficha.persistence.implementation;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.repository.IFichaObtenerPorIdRepository;
import com.ar.genesis.sistema.ficha.persistence.crud.IFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class FichaObtenerPorIdRepoImplementacion implements IFichaObtenerPorIdRepository {
    @Inject
    IFichaCRUD miFichaCRUD;

    @Override
    public Ficha obtenerFicha(Integer id) { return miFichaCRUD.findFichaByIdEquals(id); }
}
