package com.ar.genesis.sistema.permiso.core.input;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoExisteException;

public interface IPermisoModificarInput {
    boolean modificarPermiso(Permiso unPermiso) throws PermisoExisteException;
}
