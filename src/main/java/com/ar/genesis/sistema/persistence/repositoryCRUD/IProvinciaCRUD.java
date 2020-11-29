package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.Provincia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProvinciaCRUD extends CrudRepository<Provincia, Integer> {

    boolean existsByNombre(String nombre);

    List<Provincia> findAllByOrderById();
}
