package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Proveedor;
import com.ar.genesis.sistema.core.exception.ProveedorExisteException;

public interface IProveedorModificarInput {
    boolean modificarProveedor(Proveedor unProveedor) throws ProveedorExisteException;
}
