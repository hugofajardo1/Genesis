package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.exception.SucursalNoExisteException;

public interface ISucursalObtenerPorIdInput {
    Sucursal obtenerSucursal(Integer id) throws SucursalNoExisteException;
}
