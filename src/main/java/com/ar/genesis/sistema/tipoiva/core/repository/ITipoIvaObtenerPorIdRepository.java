package com.ar.genesis.sistema.tipoiva.core.repository;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;

public interface ITipoIvaObtenerPorIdRepository {
    TipoIva obtenerTipoIva(Integer id);
}
