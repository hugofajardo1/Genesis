package com.ar.genesis.sistema.ubicacion.persistence.crud;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUbicacionCRUD extends CrudRepository<Ubicacion, Integer> {

    boolean existsByNombre(String nombre);

    List<Ubicacion> findAllByOrderById();

    Ubicacion findUbicacionByIdEquals(Integer i);
}
