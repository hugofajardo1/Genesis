package com.ar.genesis.sistema.tipounidad.persistence.crud;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoUnidadCRUD extends CrudRepository<TipoUnidad, Integer> {

    boolean existsByNombre(String nombre);

    List<TipoUnidad> findAllByOrderById();

    TipoUnidad findTipoUnidadByIdEquals(Integer id);
}
