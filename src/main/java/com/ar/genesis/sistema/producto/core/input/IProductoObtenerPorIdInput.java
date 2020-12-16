package com.ar.genesis.sistema.producto.core.input;

import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.producto.core.exception.ProductoNoExisteException;

public interface IProductoObtenerPorIdInput {
    Producto obtenerProducto(Integer id) throws ProductoNoExisteException;
}
