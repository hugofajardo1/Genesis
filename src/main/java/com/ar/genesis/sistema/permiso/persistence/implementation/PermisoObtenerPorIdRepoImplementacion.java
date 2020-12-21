package com.ar.genesis.sistema.permiso.persistence.implementation;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.repository.IPermisoObtenerPorIdRepository;
import com.ar.genesis.sistema.permiso.persistence.crud.IPermisoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class PermisoObtenerPorIdRepoImplementacion implements IPermisoObtenerPorIdRepository {
    @Inject
    IPermisoCRUD miPermisoCRUD;

    @Override
    public Permiso obtenerPermiso(Integer id) { return miPermisoCRUD.findPermisoByIdEquals(id); }
}
