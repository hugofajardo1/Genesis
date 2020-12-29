package com.ar.genesis.sistema.tipooperacion.core.repository;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;

import java.util.List;

public interface ITipoOperacionObtenerRepository {
    List<TipoOperacion> obtenerTipoOperaciones();
}
