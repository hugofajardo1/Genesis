package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.TipoCliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoClienteCRUD extends CrudRepository<TipoCliente, Integer> {

    boolean existsByNombre(String nombre);
}
