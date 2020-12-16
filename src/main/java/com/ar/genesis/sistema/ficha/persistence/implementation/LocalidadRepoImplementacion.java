package com.ar.genesis.sistema.ficha.persistence.implementation;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.repository.ILocalidadRepository;
import com.ar.genesis.sistema.localidad.persistence.crud.ILocalidadCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class LocalidadRepoImplementacion implements ILocalidadRepository {

    @Inject
    ILocalidadCRUD miLocalidadCRUD;

    @Override
    public boolean existeLocalidad(String nombre) { return miLocalidadCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarLocalidad(Localidad unaLocalidad) { return miLocalidadCRUD.save(unaLocalidad).getId()!=null; }
}
