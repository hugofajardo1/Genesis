package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioNoExisteException;

public interface IUsuarioObtenerPorNombreUsuarioYContraseniaRepository {
    Usuario obtenerUsuario(String nombreUsuario, String contrasenia);
}
