package com.ar.genesis.sistema.permisousuario.core.input;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioNoExisteException;

public interface IPermisoUsuarioEliminarInput {
    boolean eliminarPermisoUsuario(PermisoUsuario unPermisoUsuario) throws PermisoUsuarioNoExisteException;
}
