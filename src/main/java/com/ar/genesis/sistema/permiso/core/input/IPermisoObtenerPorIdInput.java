package com.ar.genesis.sistema.permiso.core.input;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoNoExisteException;

public interface IPermisoObtenerPorIdInput {
    Permiso obtenerPermiso(Integer id) throws PermisoNoExisteException;
}
