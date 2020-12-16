package com.ar.genesis.sistema.tipounidad.persistence.implementation;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.core.repository.ITipoUnidadObtenerPorIdRepository;
import com.ar.genesis.sistema.tipounidad.persistence.crud.ITipoUnidadCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TipoUnidadObtenerPorIdRepoImplementacion implements ITipoUnidadObtenerPorIdRepository {
    @Inject
    ITipoUnidadCRUD miTipoUnidadCRUD;

    @Override
    public TipoUnidad obtenerTipoUnidad(Integer id) { return miTipoUnidadCRUD.findTipoUnidadByIdEquals(id); }
}
