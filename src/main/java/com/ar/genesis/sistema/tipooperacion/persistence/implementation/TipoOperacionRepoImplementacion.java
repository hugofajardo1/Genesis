package com.ar.genesis.sistema.tipooperacion.persistence.implementation;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.repository.ITipoOperacionRepository;
import com.ar.genesis.sistema.tipooperacion.persistence.crud.ITipoOperacionCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoOperacionRepoImplementacion implements ITipoOperacionRepository {

    @Inject
    ITipoOperacionCRUD miTipoOperacionCRUD;

    @Override
    public boolean existeTipoOperacion(String nombre) { return miTipoOperacionCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarTipoOperacion(TipoOperacion unTipoOperacion) { return miTipoOperacionCRUD.save(unTipoOperacion).getId()!=null; }
}
