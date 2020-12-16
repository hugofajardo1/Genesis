package com.ar.genesis.sistema.producto.core.repository;

import com.ar.genesis.sistema.producto.core.domain.Producto;

public interface IProductoObtenerPorIdRepository {
    Producto obtenerProducto(Integer id);
}
