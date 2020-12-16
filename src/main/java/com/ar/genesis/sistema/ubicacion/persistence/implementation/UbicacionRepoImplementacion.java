package com.ar.genesis.sistema.ubicacion.persistence.implementation;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.repository.IUbicacionRepository;
import com.ar.genesis.sistema.ubicacion.persistence.crud.IUbicacionCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UbicacionRepoImplementacion implements IUbicacionRepository {

    @Inject
    IUbicacionCRUD miUbicacionCRUD;

    @Override
    public boolean existeUbicacion(String nombre) { return miUbicacionCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarUbicacion(Ubicacion unaUbicacion) { return miUbicacionCRUD.save(unaUbicacion).getId()!=null; }
}
