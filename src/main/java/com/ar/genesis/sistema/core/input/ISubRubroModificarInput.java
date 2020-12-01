package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;

public interface ISubRubroModificarInput {
    boolean modificarSubRubro(SubRubro unSubRubro) throws SubRubroExisteException;
}