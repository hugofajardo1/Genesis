package com.ar.genesis.sistema.sucursal.core.input;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.sucursal.core.exception.SucursalNoExisteException;

public interface ISucursalObtenerPorIdInput {
    Sucursal obtenerSucursal(Integer id) throws SucursalNoExisteException;
}
