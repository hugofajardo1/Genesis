package com.ar.genesis.sistema.proveedor.core.input;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.exception.ProveedorExisteException;

public interface IProveedorCrearInput {
    boolean crearProveedor(Proveedor unProveedor) throws ProveedorExisteException;
}
