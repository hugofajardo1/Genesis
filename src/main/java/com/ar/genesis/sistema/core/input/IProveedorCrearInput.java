package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Proveedor;
import com.ar.genesis.sistema.core.exception.ProveedorExisteException;

public interface IProveedorCrearInput {
    boolean crearProveedor(Proveedor unProveedor) throws ProveedorExisteException;
}
