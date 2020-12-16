package com.ar.genesis.sistema.producto.persistence.implementation;

import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.producto.core.repository.IProductoRepository;
import com.ar.genesis.sistema.movimiento.persistence.crud.IProductoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ProductoRepoImplementacion implements IProductoRepository {

    @Inject
    IProductoCRUD miProductoCRUD;

    @Override
    public boolean existeProducto(String nombre) { return miProductoCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarProducto(Producto unProducto) { return miProductoCRUD.save(unProducto).getId()!=null; }
}
