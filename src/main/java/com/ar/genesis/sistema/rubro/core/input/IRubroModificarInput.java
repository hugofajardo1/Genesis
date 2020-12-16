package com.ar.genesis.sistema.rubro.core.input;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.exception.RubroExisteException;

public interface IRubroModificarInput {
    boolean modificarRubro(Rubro unRubro) throws RubroExisteException;
}
