package com.ar.genesis.sistema.permisousuario.core.repository;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;

public interface IPermisoUsuarioObtenerPorIdRepository {
    PermisoUsuario obtenerPermisoUsuario(Integer id);
}
