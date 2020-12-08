package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaNoExisteException;

public interface IProvinciaObtenerPorIdInput {
    Provincia obtenerProvincia(Integer id) throws ProvinciaNoExisteException;
}
