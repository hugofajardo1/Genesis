package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteCRUD extends CrudRepository<Cliente, Integer> {

    boolean existsByNombre(String nombre);

    List<Cliente> findAllByOrderById();

}
