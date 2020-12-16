package com.ar.genesis.sistema.producto.persistence.implementation;

import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.producto.core.repository.IProductoObtenerPorIdRepository;
import com.ar.genesis.sistema.movimiento.persistence.crud.IProductoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ProductoObtenerPorIdRepoImplementacion implements IProductoObtenerPorIdRepository {
    @Inject
    IProductoCRUD miProductoCRUD;

    @Override
    public Producto obtenerProducto(Integer id) { return miProductoCRUD.findProductoByIdEquals(id); }
}
