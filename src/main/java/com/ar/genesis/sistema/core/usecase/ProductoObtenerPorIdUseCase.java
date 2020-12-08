package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.core.exception.ProductoNoExisteException;
import com.ar.genesis.sistema.core.input.IProductoObtenerPorIdInput;
import com.ar.genesis.sistema.core.repository.IProductoObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductoObtenerPorIdUseCase implements IProductoObtenerPorIdInput {

    IProductoObtenerPorIdRepository miProductoObtenerPorIdRepository;

    public ProductoObtenerPorIdUseCase(IProductoObtenerPorIdRepository miProductoObtenerPorIdRepository) { this.miProductoObtenerPorIdRepository = miProductoObtenerPorIdRepository; }

    @Override
    public Producto obtenerProducto(Integer id) throws ProductoNoExisteException {
        Producto unProducto = miProductoObtenerPorIdRepository.obtenerProducto(id);
        if(unProducto==null){
            throw new ProductoNoExisteException();
        }
        return unProducto;
    }
}
