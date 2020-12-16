package com.ar.genesis.sistema.sucursal.core.input;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.sucursal.core.exception.SucursalExisteException;

public interface ISucursalCrearInput {
    boolean crearSucursal(Sucursal unaSucursal) throws SucursalExisteException;
}
