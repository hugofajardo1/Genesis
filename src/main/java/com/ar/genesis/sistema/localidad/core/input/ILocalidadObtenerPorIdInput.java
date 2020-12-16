package com.ar.genesis.sistema.localidad.core.input;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.exception.LocalidadNoExisteException;

public interface ILocalidadObtenerPorIdInput {
    Localidad obtenerLocalidad(Integer id) throws LocalidadNoExisteException;
}
