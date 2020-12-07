package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Usuario;

public interface IUsuarioObtenerPorIdRepository {
    Usuario obtenerUsuario(Integer id);
}
