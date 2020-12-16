package com.ar.genesis.sistema.producto.core.input;

import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.producto.core.exception.ProductoExisteException;

public interface IProductoCrearInput {
    boolean crearProducto(Producto unProducto) throws ProductoExisteException;
}
