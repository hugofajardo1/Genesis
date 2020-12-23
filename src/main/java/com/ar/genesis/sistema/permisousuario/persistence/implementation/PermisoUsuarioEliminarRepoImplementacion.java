package com.ar.genesis.sistema.permisousuario.persistence.implementation;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.repository.IPermisoUsuarioEliminarRepository;
import com.ar.genesis.sistema.permisousuario.persistence.crud.IPermisoUsuarioCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class PermisoUsuarioEliminarRepoImplementacion implements IPermisoUsuarioEliminarRepository {

    @Inject
    IPermisoUsuarioCRUD miPermisoUsuarioCRUD;

    @Override
    public boolean existePermisoUsuario(PermisoUsuario unPermisoUsuario) { return miPermisoUsuarioCRUD.existsPermisoUsuarioByPermisoAndUsuario(unPermisoUsuario.getPermiso(), unPermisoUsuario.getUsuario()); }

    @Override
    public boolean eliminarPermisoUsuario(PermisoUsuario unPermisoUsuario) {
        Integer permisoid = unPermisoUsuario.getId();
        miPermisoUsuarioCRUD.delete(unPermisoUsuario);
        return !miPermisoUsuarioCRUD.existsById(permisoid);
    }
}
