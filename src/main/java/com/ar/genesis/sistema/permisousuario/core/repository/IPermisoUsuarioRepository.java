package com.ar.genesis.sistema.permisousuario.core.repository;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;

public interface IPermisoUsuarioRepository {
    boolean existePermisoUsuario(PermisoUsuario unPermisoUsuario);

    boolean guardarPermisoUsuario(PermisoUsuario unPermisoUsuario);
}
