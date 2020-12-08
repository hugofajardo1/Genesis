package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.repository.ILocalidadObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ILocalidadCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class LocalidadObtenerPorIdRepoImplementacion implements ILocalidadObtenerPorIdRepository {
    @Inject
    ILocalidadCRUD miLocalidadCRUD;

    @Override
    public Localidad obtenerLocalidad(Integer id) { return miLocalidadCRUD.findLocalidadByIdEquals(id); }
}
