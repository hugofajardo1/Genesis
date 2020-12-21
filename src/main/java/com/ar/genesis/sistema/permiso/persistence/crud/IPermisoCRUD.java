package com.ar.genesis.sistema.permiso.persistence.crud;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPermisoCRUD extends CrudRepository<Permiso, Integer> {

    boolean existsByNombre(String nombre);

    List<Permiso> findAllByOrderById();

    Permiso findPermisoByIdEquals(Integer id);
}
