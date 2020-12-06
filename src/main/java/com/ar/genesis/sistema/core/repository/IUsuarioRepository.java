package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Usuario;

public interface IUsuarioRepository {
    boolean existeUsuario(String nombre);

    boolean guardarUsuario(Usuario Usuario);
}
