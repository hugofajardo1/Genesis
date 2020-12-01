package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.core.exception.ProductoExisteException;

public interface IProductoModificarInput {
    boolean modificarProducto(Producto unProducto) throws ProductoExisteException;
}
