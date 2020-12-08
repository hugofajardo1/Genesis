package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.core.exception.ProductoNoExisteException;

public interface IProductoObtenerPorIdInput {
    Producto obtenerProducto(Integer id) throws ProductoNoExisteException;
}
