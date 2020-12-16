package com.ar.genesis.sistema.proveedor.core.input;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.exception.ProveedorNoExisteException;

public interface IProveedorObtenerPorIdInput {
    Proveedor obtenerProveedor(Integer id) throws ProveedorNoExisteException;
}
