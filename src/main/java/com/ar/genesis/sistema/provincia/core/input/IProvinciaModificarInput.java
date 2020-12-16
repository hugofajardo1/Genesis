package com.ar.genesis.sistema.provincia.core.input;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.exception.ProvinciaExisteException;

public interface IProvinciaModificarInput {
    boolean modificarProvincia(Provincia unaProvincia) throws ProvinciaExisteException;
}
