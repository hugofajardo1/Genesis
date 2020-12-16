package com.ar.genesis.sistema.proveedor.core.input;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.exception.ProveedorExisteException;

public interface IProveedorModificarInput {
    boolean modificarProveedor(Proveedor unProveedor) throws ProveedorExisteException;
}
