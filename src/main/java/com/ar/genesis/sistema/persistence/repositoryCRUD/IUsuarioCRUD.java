package com.ar.genesis.sistema.persistence.repositoryCRUD;

import com.ar.genesis.sistema.core.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioCRUD extends CrudRepository<Usuario, Integer> {

    boolean existsByNombre(String nombre);

    List<Usuario> findAllByOrderById();

    Usuario findByNombreUsuarioEqualsAndContraseniaEquals(String nombreUsuario, String contrasenia);

    Usuario findUsuarioByIdEquals(Integer id);
}
