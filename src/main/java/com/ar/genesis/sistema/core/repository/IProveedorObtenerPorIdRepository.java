package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Proveedor;

public interface IProveedorObtenerPorIdRepository {
    Proveedor obtenerProveedor(Integer id);
}