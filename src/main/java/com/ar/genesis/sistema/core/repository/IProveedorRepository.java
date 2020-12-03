package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Proveedor;

public interface IProveedorRepository {
    boolean existeProveedor(String nombre);

    boolean guardarProveedor(Proveedor Proveedor);
}
