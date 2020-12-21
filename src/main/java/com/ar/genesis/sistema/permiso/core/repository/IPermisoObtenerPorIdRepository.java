package com.ar.genesis.sistema.permiso.core.repository;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;

public interface IPermisoObtenerPorIdRepository {
    Permiso obtenerPermiso(Integer id);
}
