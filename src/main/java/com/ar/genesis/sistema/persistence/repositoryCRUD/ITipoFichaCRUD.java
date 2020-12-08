package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoFichaCRUD extends CrudRepository<TipoFicha, Integer> {

    boolean existsByNombre(String nombre);

    List<TipoFicha> findAllByOrderById();

    TipoFicha findTipoFichaByIdEquals(Integer id);
}
