package com.ar.genesis.sistema.usuario.core.repository;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;

import java.util.List;

public interface IUsuarioObtenerRepository {
    List<Usuario> obtenerUsuarios();
}
