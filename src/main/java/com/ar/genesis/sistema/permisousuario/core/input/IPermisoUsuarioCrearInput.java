package com.ar.genesis.sistema.permisousuario.core.input;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioExisteException;

public interface IPermisoUsuarioCrearInput {
    boolean crearPermisoUsuario(PermisoUsuario unPermisoUsuario) throws PermisoUsuarioExisteException;
}
