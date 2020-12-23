package com.ar.genesis.sistema.permisousuario.persistence.implementation;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.repository.IPermisoUsuarioObtenerPorIdRepository;
import com.ar.genesis.sistema.permisousuario.persistence.crud.IPermisoUsuarioCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class PermisoUsuarioObtenerPorIdRepoImplementacion implements IPermisoUsuarioObtenerPorIdRepository {
    @Inject
    IPermisoUsuarioCRUD miPermisoUsuarioCRUD;

    @Override
    public PermisoUsuario obtenerPermisoUsuario(Integer id) { return miPermisoUsuarioCRUD.findPermisoUsuarioByIdEquals(id); }
}
