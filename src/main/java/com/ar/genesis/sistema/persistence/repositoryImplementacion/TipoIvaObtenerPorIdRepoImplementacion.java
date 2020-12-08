package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.repository.ITipoIvaObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ITipoIvaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoIvaObtenerPorIdRepoImplementacion implements ITipoIvaObtenerPorIdRepository {
    @Inject
    ITipoIvaCRUD miTipoIvaCRUD;

    @Override
    public TipoIva obtenerTipoIva(Integer id) { return miTipoIvaCRUD.findTipoIvaByIdEquals(id); }
}
