package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Usuario;

import java.util.List;

public interface IUsuarioObtenerRepository {
    List<Usuario> obtenerUsuarios();
}
