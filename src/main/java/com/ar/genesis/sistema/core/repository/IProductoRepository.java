package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Producto;

public interface IProductoRepository {
    boolean existeProducto(String nombre);

    boolean guardarProducto(Producto unProducto);
}
