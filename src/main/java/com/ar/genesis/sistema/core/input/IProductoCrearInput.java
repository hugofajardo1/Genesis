package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.core.exception.ProductoExisteException;

public interface IProductoCrearInput {
    boolean crearProducto(Producto unProducto) throws ProductoExisteException;
}
