package com.ar.genesis.sistema.permiso.core.input;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;

import java.util.List;

public interface IPermisoObtenerInput {
    List<Permiso> obtenerPermisos();
}
