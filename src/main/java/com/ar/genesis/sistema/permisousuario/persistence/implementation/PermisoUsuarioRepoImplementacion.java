package com.ar.genesis.sistema.permisousuario.persistence.implementation;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.repository.IPermisoUsuarioRepository;
import com.ar.genesis.sistema.permisousuario.persistence.crud.IPermisoUsuarioCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class PermisoUsuarioRepoImplementacion implements IPermisoUsuarioRepository {

    @Inject
    IPermisoUsuarioCRUD miPermisoUsuarioCRUD;

    @Override
    public boolean existePermisoUsuario(PermisoUsuario unPermisoUsuario) { return miPermisoUsuarioCRUD.existsPermisoUsuarioByPermisoAndUsuario(unPermisoUsuario.getPermiso(), unPermisoUsuario.getUsuario()); }

    @Override
    public boolean guardarPermisoUsuario(PermisoUsuario unPermisoUsuario) { return miPermisoUsuarioCRUD.save(unPermisoUsuario).getPermiso().getId()!=null; }
}
