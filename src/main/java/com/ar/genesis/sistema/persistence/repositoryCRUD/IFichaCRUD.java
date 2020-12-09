package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.Ficha;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFichaCRUD extends CrudRepository<Ficha, Integer> {

    boolean existsByNombre(String nombre);

    List<Ficha> findAllByOrderById();

    Ficha findFichaByIdEquals(Integer id);
}
