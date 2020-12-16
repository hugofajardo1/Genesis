package com.ar.genesis.sistema.tipoiva.persistence.implementation;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.repository.ITipoIvaObtenerPorIdRepository;
import com.ar.genesis.sistema.tipoiva.persistence.crud.ITipoIvaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoIvaObtenerPorIdRepoImplementacion implements ITipoIvaObtenerPorIdRepository {
    @Inject
    ITipoIvaCRUD miTipoIvaCRUD;

    @Override
    public TipoIva obtenerTipoIva(Integer id) { return miTipoIvaCRUD.findTipoIvaByIdEquals(id); }
}
