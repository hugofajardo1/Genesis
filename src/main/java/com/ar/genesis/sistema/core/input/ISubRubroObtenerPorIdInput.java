package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroNoExisteException;

public interface ISubRubroObtenerPorIdInput {
    SubRubro obtenerSubRubro(Integer id) throws SubRubroNoExisteException;
}
