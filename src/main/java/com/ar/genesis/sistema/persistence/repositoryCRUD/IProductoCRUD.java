package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoCRUD extends CrudRepository<Producto, Integer> {

    boolean existsByNombre(String nombre);

    List<Producto> findAllByOrderById();

    Producto findProductoByIdEquals(Integer id);
}
