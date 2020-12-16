package com.ar.genesis.sistema.producto.core.input;

import com.ar.genesis.sistema.producto.core.domain.Producto;

import java.util.List;

public interface IProductoObtenerInput {
    List<Producto> obtenerProductos();
}
