package com.ar.genesis.sistema.tipoiva.persistence.crud;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoIvaCRUD extends CrudRepository<TipoIva, Integer> {

    boolean existsByNombre(String nombre);

    List<TipoIva> findAllByOrderById();

    TipoIva findTipoIvaByIdEquals(Integer id);
}
