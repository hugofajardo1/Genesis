package com.ar.genesis.sistema.permiso.core.repository;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;

import java.util.List;

public interface IPermisoObtenerRepository {
    List<Permiso> obtenerPermisos();
}
