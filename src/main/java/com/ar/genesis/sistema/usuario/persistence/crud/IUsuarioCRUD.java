package com.ar.genesis.sistema.usuario.persistence.crud;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioCRUD extends CrudRepository<Usuario, Integer> {

    boolean existsByNombre(String nombre);

    List<Usuario> findAllByOrderById();

    Usuario findByNombreUsuarioEqualsAndContraseniaEquals(String nombreUsuario, String contrasenia);

    Usuario findUsuarioByIdEquals(Integer id);
}
