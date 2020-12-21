package com.ar.genesis.sistema.permiso.core.repository;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;

public interface IPermisoRepository {
    boolean existePermiso(String nombre);

    boolean guardarPermiso(Permiso unPermiso);
}
