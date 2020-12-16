package com.ar.genesis.sistema.sucursal.persistence.crud;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISucursalCRUD extends CrudRepository<Sucursal, Integer> {

    boolean existsByNombre(String nombre);

    List<Sucursal> findAllByOrderById();

    Sucursal findSucursalByIdEquals(Integer i);
}
