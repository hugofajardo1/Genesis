package com.ar.genesis.sistema.ficha.persistence.implementation;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.repository.ILocalidadObtenerPorIdRepository;
import com.ar.genesis.sistema.localidad.persistence.crud.ILocalidadCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class LocalidadObtenerPorIdRepoImplementacion implements ILocalidadObtenerPorIdRepository {
    @Inject
    ILocalidadCRUD miLocalidadCRUD;

    @Override
    public Localidad obtenerLocalidad(Integer id) { return miLocalidadCRUD.findLocalidadByIdEquals(id); }
}
