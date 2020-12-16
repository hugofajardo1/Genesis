package com.ar.genesis.sistema.producto.core.usecase;

import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.producto.core.input.IProductoObtenerInput;
import com.ar.genesis.sistema.producto.core.repository.IProductoObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoObtenerUseCase implements IProductoObtenerInput {

    IProductoObtenerRepository miProductoObtenerRepository;

    public ProductoObtenerUseCase(IProductoObtenerRepository miProductoObtenerRepository) { this.miProductoObtenerRepository = miProductoObtenerRepository; }

    @Override
    public List<Producto> obtenerProductos() {
        return miProductoObtenerRepository.obtenerProductos();
    }
}
