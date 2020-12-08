package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Producto;

public interface IProductoObtenerPorIdRepository {
    Producto obtenerProducto(Integer id);
}
