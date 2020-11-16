package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.repository.ITipoFichaRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoFichaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoFichaRepoImplementacion implements ITipoFichaRepository {

    @Inject
    ITipoFichaCRUD tipoClienteCRUD;

    @Override
    public boolean existeTipoCliente(String nombre) { return tipoClienteCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarTipoCliente(TipoFicha unTipoFicha) { return tipoClienteCRUD.save(unTipoFicha).getId()!=null; }
}
