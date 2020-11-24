package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.repository.ITipoFichaRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoFichaRepoImplementacion implements ITipoFichaRepository {

    @Inject
    ITipoFichaCRUD tipoFichaCRUD;

    @Override
    public boolean existeTipoFicha(String nombre) { return tipoFichaCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarTipoFicha(TipoFicha unTipoFicha) { return tipoFichaCRUD.save(unTipoFicha).getId()!=null; }
}
