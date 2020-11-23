package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUbicacionCRUD extends CrudRepository<Ubicacion, Integer> {

    boolean existsByNombre(String nombre);

    List<Ubicacion> findAllByOrderById();
}
