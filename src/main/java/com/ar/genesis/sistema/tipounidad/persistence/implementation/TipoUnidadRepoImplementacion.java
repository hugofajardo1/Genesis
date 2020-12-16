package com.ar.genesis.sistema.tipounidad.persistence.implementation;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.core.repository.ITipoUnidadRepository;
import com.ar.genesis.sistema.tipounidad.persistence.crud.ITipoUnidadCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoUnidadRepoImplementacion implements ITipoUnidadRepository {

    @Inject
    ITipoUnidadCRUD miTipoUnidadCRUD;

    @Override
    public boolean existeTipoUnidad(String nombre) { return miTipoUnidadCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarTipoUnidad(TipoUnidad unTipoUnidad) { return miTipoUnidadCRUD.save(unTipoUnidad).getId()!=null; }
}
