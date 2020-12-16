package com.ar.genesis.sistema.producto.persistence.implementation;

import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.producto.core.repository.IProductoObtenerRepository;
import com.ar.genesis.sistema.movimiento.persistence.crud.IProductoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ProductoObtenerRepoImplementacion implements IProductoObtenerRepository {
    @Inject
    IProductoCRUD miProductoCRUD;

    @Override
    public List<Producto> obtenerProductos() {
        return miProductoCRUD.findAllByOrderById();
    }
}
