package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoFichaCRUD extends CrudRepository<TipoFicha, Integer> {

    boolean existsByNombre(String nombre);
}
