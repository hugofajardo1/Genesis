package com.ar.genesis.sistema.tipooperacion.persistence.crud;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoOperacionCRUD extends CrudRepository<TipoOperacion, Integer> {

    boolean existsByNombre(String nombre);

    List<TipoOperacion> findAllByOrderById();

    TipoOperacion findTipoOperacionByIdEquals(Integer id);
}
