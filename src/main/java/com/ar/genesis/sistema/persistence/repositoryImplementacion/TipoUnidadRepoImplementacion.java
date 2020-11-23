package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.repository.ITipoUnidadRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoUnidadCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoUnidadRepoImplementacion implements ITipoUnidadRepository {

    @Inject
    ITipoUnidadCRUD iTipoUnidadCRUD;

    @Override
    public boolean existeTipoUnidad(String nombre) { return iTipoUnidadCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarTipoUnidad(TipoUnidad unTipoUnidad) { return iTipoUnidadCRUD.save(unTipoUnidad).getId()!=null; }
}
