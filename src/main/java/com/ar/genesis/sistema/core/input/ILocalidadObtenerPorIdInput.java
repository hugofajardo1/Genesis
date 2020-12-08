package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadNoExisteException;

public interface ILocalidadObtenerPorIdInput {
    Localidad obtenerLocalidad(Integer id) throws LocalidadNoExisteException;
}
