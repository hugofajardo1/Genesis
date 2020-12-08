package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.core.repository.IProductoObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IProductoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ProductoObtenerPorIdRepoImplementacion implements IProductoObtenerPorIdRepository {
    @Inject
    IProductoCRUD miProductoCRUD;

    @Override
    public Producto obtenerProducto(Integer id) { return miProductoCRUD.findProductoByIdEquals(id); }
}
