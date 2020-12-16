package com.ar.genesis.sistema.producto.core.usecase;

import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.producto.core.exception.ProductoExisteException;
import com.ar.genesis.sistema.producto.core.input.IProductoCrearInput;
import com.ar.genesis.sistema.producto.core.repository.IProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductoCrearUseCase implements IProductoCrearInput {

    IProductoRepository miProductoRepository;

    public ProductoCrearUseCase(IProductoRepository miProductoRepository) {
        this.miProductoRepository = miProductoRepository;
    }

    @Override
    public boolean crearProducto(Producto unProducto) throws ProductoExisteException {
        if(miProductoRepository.existeProducto(unProducto.getNombre())){
            throw new ProductoExisteException();
        }
        return miProductoRepository.guardarProducto(unProducto);
    }
}
