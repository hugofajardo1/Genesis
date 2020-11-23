package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.domain.TipoIva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoIvaCRUD extends CrudRepository<TipoIva, Integer> {

    boolean existsByNombre(String nombre);

    List<TipoIva> findAllByOrderById();
}
