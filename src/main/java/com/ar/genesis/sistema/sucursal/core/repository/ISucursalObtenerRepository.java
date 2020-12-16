package com.ar.genesis.sistema.sucursal.core.repository;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;

import java.util.List;

public interface ISucursalObtenerRepository {
    List<Sucursal> obtenerSucursales();
}
