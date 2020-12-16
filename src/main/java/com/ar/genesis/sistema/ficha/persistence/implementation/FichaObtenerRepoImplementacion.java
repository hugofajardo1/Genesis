package com.ar.genesis.sistema.ficha.persistence.implementation;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.repository.IFichaObtenerRepository;
import com.ar.genesis.sistema.ficha.persistence.crud.IFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class FichaObtenerRepoImplementacion implements IFichaObtenerRepository {
    @Inject
    IFichaCRUD miFichaCRUD;

    @Override
    public List<Ficha> obtenerFichas() {
        return miFichaCRUD.findAllByOrderById();
    }
}
