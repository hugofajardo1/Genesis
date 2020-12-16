package com.ar.genesis.sistema.usuario.core.repository;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;

public interface IUsuarioObtenerPorNombreUsuarioYContraseniaRepository {
    Usuario obtenerUsuario(String nombreUsuario, String contrasenia);
}
