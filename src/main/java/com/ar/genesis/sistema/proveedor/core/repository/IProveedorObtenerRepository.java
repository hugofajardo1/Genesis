package com.ar.genesis.sistema.proveedor.core.repository;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;

import java.util.List;

public interface IProveedorObtenerRepository {
    List<Proveedor> obtenerProveedores();
}
