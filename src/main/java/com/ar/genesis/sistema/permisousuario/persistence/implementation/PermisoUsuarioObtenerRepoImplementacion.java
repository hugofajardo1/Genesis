package com.ar.genesis.sistema.permisousuario.persistence.implementation;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.repository.IPermisoUsuarioObtenerRepository;
import com.ar.genesis.sistema.permisousuario.persistence.crud.IPermisoUsuarioCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PermisoUsuarioObtenerRepoImplementacion implements IPermisoUsuarioObtenerRepository {
    @Inject
    IPermisoUsuarioCRUD miPermisoUsuarioCRUD;

    @Override
    public List<PermisoUsuario> obtenerPermisoUsuarios() {
        return miPermisoUsuarioCRUD.findAllByOrderById();
    }
}
