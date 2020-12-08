package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Proveedor;
import com.ar.genesis.sistema.core.exception.ProveedorNoExisteException;

public interface IProveedorObtenerPorIdInput {
    Proveedor obtenerProveedor(Integer id) throws ProveedorNoExisteException;
}
