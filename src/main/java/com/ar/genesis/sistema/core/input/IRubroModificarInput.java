package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroExisteException;

public interface IRubroModificarInput {
    boolean modificarRubro(Rubro unRubro) throws RubroExisteException;
}
