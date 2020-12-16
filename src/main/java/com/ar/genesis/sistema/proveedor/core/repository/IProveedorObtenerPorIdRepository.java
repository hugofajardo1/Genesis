package com.ar.genesis.sistema.proveedor.core.repository;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;

public interface IProveedorObtenerPorIdRepository {
    Proveedor obtenerProveedor(Integer id);
}
