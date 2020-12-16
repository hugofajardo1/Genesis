package com.ar.genesis.sistema.sucursal.core.repository;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;

public interface ISucursalObtenerPorIdRepository {
    Sucursal obtenerSucursal(Integer id);
}
