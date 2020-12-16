package com.ar.genesis.sistema.provincia.persistence.crud;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProvinciaCRUD extends CrudRepository<Provincia, Integer> {

    boolean existsByNombre(String nombre);

    List<Provincia> findAllByOrderById();

    Provincia findProvinciaByIdEquals(Integer id);
}
