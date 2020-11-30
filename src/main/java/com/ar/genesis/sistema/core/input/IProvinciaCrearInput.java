package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;

public interface IProvinciaCrearInput {
    boolean crearProvincia(Provincia unaProvincia) throws ProvinciaExisteException;
}
