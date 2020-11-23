package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoUnidadCRUD extends CrudRepository<TipoUnidad, Integer> {

    boolean existsByNombre(String nombre);

    List<TipoUnidad> findAllByOrderById();

}
