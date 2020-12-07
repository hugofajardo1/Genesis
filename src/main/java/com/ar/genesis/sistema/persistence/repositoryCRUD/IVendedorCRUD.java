package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.Vendedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVendedorCRUD extends CrudRepository<Vendedor, Integer> {

    boolean existsByNombre(String nombre);

    List<Vendedor> findAllByOrderById();

    Vendedor findVendedorByIdEquals(Integer id);
}
