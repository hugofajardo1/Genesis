package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.Localidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocalidadCRUD extends CrudRepository<Localidad, Integer> {

    boolean existsByNombre(String nombre);

    List<Localidad> findAllByOrderById();
}
