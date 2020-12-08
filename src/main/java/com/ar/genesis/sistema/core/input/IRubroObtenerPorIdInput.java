package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroNoExisteException;

public interface IRubroObtenerPorIdInput {
    Rubro obtenerRubro(Integer id) throws RubroNoExisteException;
}
