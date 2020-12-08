package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProveedorCRUD extends CrudRepository<Proveedor, Integer> {

    boolean existsByNombre(String nombre);

    List<Proveedor> findAllByOrderById();

    Proveedor findProveedorByIdEquals(Integer id);
}
