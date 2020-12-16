package com.ar.genesis.sistema.proveedor.core.repository;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;

public interface IProveedorRepository {
    boolean existeProveedor(String nombre);

    boolean guardarProveedor(Proveedor Proveedor);
}
