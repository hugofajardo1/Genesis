package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.exception.SucursalExisteException;

public interface ISucursalCrearInput {
    boolean crearSucursal(Sucursal unaSucursal) throws SucursalExisteException;
}
