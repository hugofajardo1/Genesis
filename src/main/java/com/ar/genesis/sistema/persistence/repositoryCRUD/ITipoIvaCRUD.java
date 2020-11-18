package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.TipoIva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoIvaCRUD extends CrudRepository<TipoIva, Integer> {

    boolean existsByNombre(String nombre);
}
