package com.ar.genesis.sistema.rubro.persistence.crud;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRubroCRUD extends CrudRepository<Rubro, Integer> {

    boolean existsByNombre(String nombre);

    List<Rubro> findAllByOrderById();

    Rubro findRubroByIdEquals(Integer id);
}
