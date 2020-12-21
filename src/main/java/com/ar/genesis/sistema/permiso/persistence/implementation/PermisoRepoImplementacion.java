package com.ar.genesis.sistema.permiso.persistence.implementation;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.repository.IPermisoRepository;
import com.ar.genesis.sistema.permiso.persistence.crud.IPermisoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class PermisoRepoImplementacion implements IPermisoRepository {

    @Inject
    IPermisoCRUD miPermisoCRUD;

    @Override
    public boolean existePermiso(String nombre) { return miPermisoCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarPermiso(Permiso unPermiso) { return miPermisoCRUD.save(unPermiso).getId()!=null; }
}
