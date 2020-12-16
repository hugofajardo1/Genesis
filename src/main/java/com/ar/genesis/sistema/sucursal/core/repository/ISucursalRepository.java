package com.ar.genesis.sistema.sucursal.core.repository;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;

public interface ISucursalRepository {
    boolean existeSucursal(String nombre);

    boolean guardarSucursal(Sucursal Sucursal);
}
