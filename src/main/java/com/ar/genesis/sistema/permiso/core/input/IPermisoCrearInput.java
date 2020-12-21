package com.ar.genesis.sistema.permiso.core.input;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoExisteException;

public interface IPermisoCrearInput {
    boolean crearPermiso(Permiso unPermiso) throws PermisoExisteException;
}
