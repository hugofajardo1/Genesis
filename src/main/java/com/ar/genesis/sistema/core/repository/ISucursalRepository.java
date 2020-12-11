package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Sucursal;

public interface ISucursalRepository {
    boolean existeSucursal(String nombre);

    boolean guardarSucursal(Sucursal Sucursal);
}
