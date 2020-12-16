package com.ar.genesis.sistema.usuario.core.repository;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;

public interface IUsuarioObtenerPorIdRepository {
    Usuario obtenerUsuario(Integer id);
}
