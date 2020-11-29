package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.repository.ILocalidadRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ILocalidadCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class LocalidadRepoImplementacion implements ILocalidadRepository {

    @Inject
    ILocalidadCRUD miLocalidadCRUD;

    @Override
    public boolean existeLocalidad(String nombre) { return miLocalidadCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarLocalidad(Localidad localidad) { return miLocalidadCRUD.save(localidad).getId()!=null; }
}
