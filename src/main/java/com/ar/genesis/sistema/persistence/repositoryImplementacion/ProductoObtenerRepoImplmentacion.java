package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.core.repository.IProductoObtenerRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IProductoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ProductoObtenerRepoImplmentacion implements IProductoObtenerRepository {
    @Inject
    IProductoCRUD miProductoCRUD;

    @Override
    public List<Producto> obtenerProductos() {
        return miProductoCRUD.findAllByOrderById();
    }
}
