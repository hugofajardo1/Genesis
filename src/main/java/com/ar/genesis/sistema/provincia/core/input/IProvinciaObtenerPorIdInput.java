package com.ar.genesis.sistema.provincia.core.input;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.exception.ProvinciaNoExisteException;

public interface IProvinciaObtenerPorIdInput {
    Provincia obtenerProvincia(Integer id) throws ProvinciaNoExisteException;
}
