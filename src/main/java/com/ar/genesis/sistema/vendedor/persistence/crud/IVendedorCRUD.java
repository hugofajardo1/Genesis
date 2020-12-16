package com.ar.genesis.sistema.vendedor.persistence.crud;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVendedorCRUD extends CrudRepository<Vendedor, Integer> {

    boolean existsByNombre(String nombre);

    List<Vendedor> findAllByOrderById();

    Vendedor findVendedorByIdEquals(Integer id);
}
