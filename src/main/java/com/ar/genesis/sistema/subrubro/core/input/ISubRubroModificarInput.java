package com.ar.genesis.sistema.subrubro.core.input;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.core.exception.SubRubroExisteException;

public interface ISubRubroModificarInput {
    boolean modificarSubRubro(SubRubro unSubRubro) throws SubRubroExisteException;
}
