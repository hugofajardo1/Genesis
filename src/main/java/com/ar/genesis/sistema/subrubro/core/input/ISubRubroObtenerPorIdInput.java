package com.ar.genesis.sistema.subrubro.core.input;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.core.exception.SubRubroNoExisteException;

public interface ISubRubroObtenerPorIdInput {
    SubRubro obtenerSubRubro(Integer id) throws SubRubroNoExisteException;
}
