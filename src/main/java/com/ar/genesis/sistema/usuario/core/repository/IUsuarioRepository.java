package com.ar.genesis.sistema.usuario.core.repository;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;

public interface IUsuarioRepository {
    boolean existeUsuario(String nombre);

    boolean guardarUsuario(Usuario Usuario);
}
