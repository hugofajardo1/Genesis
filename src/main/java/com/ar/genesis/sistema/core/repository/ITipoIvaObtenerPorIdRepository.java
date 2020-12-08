package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.TipoIva;

public interface ITipoIvaObtenerPorIdRepository {
    TipoIva obtenerTipoIva(Integer id);
}
