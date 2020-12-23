package com.ar.genesis.sistema.permisousuario.persistence.crud;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPermisoUsuarioCRUD extends CrudRepository<PermisoUsuario, Integer> {

    boolean existsPermisoUsuarioByPermisoAndUsuario(Permiso unPermiso, Usuario unUsuario);

    List<PermisoUsuario> findAllByOrderById();

    PermisoUsuario findPermisoUsuarioByIdEquals(Integer id);
}
