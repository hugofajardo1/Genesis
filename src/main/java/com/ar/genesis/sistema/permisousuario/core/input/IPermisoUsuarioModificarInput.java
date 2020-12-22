package com.ar.genesis.sistema.permisousuario.core.input;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioExisteException;

public interface IPermisoUsuarioModificarInput {
    boolean modificarPermisoUsuario(PermisoUsuario unPermisoUsuario) throws PermisoUsuarioExisteException;
}
