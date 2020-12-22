package com.ar.genesis.sistema.permisousuario.core.repository;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;

import java.util.List;

public interface IPermisoUsuarioObtenerRepository {
    List<PermisoUsuario> obtenerPermisoUsuarios();
}
