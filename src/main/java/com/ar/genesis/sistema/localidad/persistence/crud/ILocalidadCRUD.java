package com.ar.genesis.sistema.localidad.persistence.crud;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocalidadCRUD extends CrudRepository<Localidad, Integer> {

    boolean existsByNombre(String nombre);

    List<Localidad> findAllByOrderById();

    Localidad findLocalidadByIdEquals(Integer id);
}
