package com.ar.genesis.sistema.producto.core.repository;

import com.ar.genesis.sistema.producto.core.domain.Producto;

public interface IProductoRepository {
    boolean existeProducto(String nombre);

    boolean guardarProducto(Producto unProducto);
}
