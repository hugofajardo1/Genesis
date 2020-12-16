package com.ar.genesis.sistema.producto.core.input;

import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.producto.core.exception.ProductoExisteException;

public interface IProductoModificarInput {
    boolean modificarProducto(Producto unProducto) throws ProductoExisteException;
}
