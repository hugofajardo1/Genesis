package com.ar.genesis.sistema.permisousuario.core.input;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;

import java.util.List;

public interface IPermisoUsuarioObtenerInput {
    List<PermisoUsuario> obtenerPermisoUsuarios();
}
