package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.repository.ITipoFichaObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoFichaObtenerPorIdRepoImplementacion implements ITipoFichaObtenerPorIdRepository {
    @Inject
    ITipoFichaCRUD miTipoFichaCRUD;

    @Override
    public TipoFicha obtenerTipoFicha(Integer id) { return miTipoFichaCRUD.findTipoFichaByIdEquals(id); }
}
