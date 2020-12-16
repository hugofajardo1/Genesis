package com.ar.genesis.sistema.movimiento.persistence.crud;

import com.ar.genesis.sistema.producto.core.domain.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoCRUD extends CrudRepository<Producto, Integer> {

    boolean existsByNombre(String nombre);

    List<Producto> findAllByOrderById();

    Producto findProductoByIdEquals(Integer id);
}
