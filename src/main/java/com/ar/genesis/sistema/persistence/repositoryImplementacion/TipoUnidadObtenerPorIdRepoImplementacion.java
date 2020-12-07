package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.repository.ITipoUnidadObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoUnidadCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoUnidadObtenerPorIdRepoImplementacion implements ITipoUnidadObtenerPorIdRepository {
    @Inject
    ITipoUnidadCRUD miTipoUnidadCRUD;

    @Override
    public TipoUnidad obtenerTipoUnidad(Integer id) { return miTipoUnidadCRUD.findTipoUnidadByIdEquals(id); }
}
