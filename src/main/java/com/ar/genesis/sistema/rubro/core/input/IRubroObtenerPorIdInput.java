package com.ar.genesis.sistema.rubro.core.input;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.exception.RubroNoExisteException;

public interface IRubroObtenerPorIdInput {
    Rubro obtenerRubro(Integer id) throws RubroNoExisteException;
}
