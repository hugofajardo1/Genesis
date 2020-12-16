package com.ar.genesis.sistema.provincia.core.input;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.exception.ProvinciaExisteException;

public interface IProvinciaCrearInput {
    boolean crearProvincia(Provincia unaProvincia) throws ProvinciaExisteException;
}
