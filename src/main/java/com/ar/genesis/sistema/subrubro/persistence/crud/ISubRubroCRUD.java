package com.ar.genesis.sistema.subrubro.persistence.crud;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISubRubroCRUD extends CrudRepository<SubRubro, Integer> {

    boolean existsByNombre(String nombre);

    List<SubRubro> findAllByOrderById();

    SubRubro findSubRubroByIdEquals(Integer id);
}
