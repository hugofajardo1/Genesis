package com.ar.genesis.sistema.producto.core.repository;

import com.ar.genesis.sistema.producto.core.domain.Producto;

import java.util.List;

public interface IProductoObtenerRepository {
    List<Producto> obtenerProductos();
}
