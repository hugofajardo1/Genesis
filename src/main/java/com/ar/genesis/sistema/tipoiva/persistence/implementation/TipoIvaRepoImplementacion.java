package com.ar.genesis.sistema.tipoiva.persistence.implementation;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.repository.ITipoIvaRepository;
import com.ar.genesis.sistema.tipoiva.persistence.crud.ITipoIvaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoIvaRepoImplementacion implements ITipoIvaRepository {

    @Inject
    ITipoIvaCRUD miTipoIvaCRUD;

    @Override
    public boolean existeTipoIva(String nombre) { return miTipoIvaCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarTipoIva(TipoIva unTipoIva) { return miTipoIvaCRUD.save(unTipoIva).getId()!=null; }
}
