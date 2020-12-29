package com.ar.genesis.sistema.tipooperacion.core.repository;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionNoExisteException;

public interface ITipoOperacionObtenerPorIdRepository {
    TipoOperacion obtenerTipoOperacion(Integer id);
}
