package com.ar.genesis.sistema.permisousuario.core.repository;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;

public interface IPermisoUsuarioEliminarRepository {
    boolean existePermisoUsuario(PermisoUsuario unPermisoUsuario);

    boolean eliminarPermisoUsuario(PermisoUsuario unPermisoUsuario);
}
