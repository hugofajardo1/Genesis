package com.ar.genesis.sistema.tipoiva.core.repository;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;

import java.util.List;

public interface ITipoIvaObtenerRepository {
    List<TipoIva> obtenerTipoIvas();
}
