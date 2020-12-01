package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Producto;

import java.util.List;

public interface IProductoObtenerRepository {
    List<Producto> obtenerProductos();
}
