package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioCRUD extends CrudRepository<Usuario, Integer> {

    boolean existsByNombre(String nombre);

    List<Usuario> findAllByOrderById();
}
