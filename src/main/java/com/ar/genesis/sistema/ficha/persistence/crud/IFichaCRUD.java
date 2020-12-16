package com.ar.genesis.sistema.ficha.persistence.crud;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFichaCRUD extends CrudRepository<Ficha, Integer> {

    boolean existsByNombre(String nombre);

    List<Ficha> findAllByOrderById();

    Ficha findFichaByIdEquals(Integer id);
}
