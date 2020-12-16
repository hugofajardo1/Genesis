package com.ar.genesis.sistema.usuario.core.input;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioNoExisteException;

public interface IUsuarioObtenerPorIdInput {
    Usuario obtenerUsuario(Integer id) throws UsuarioNoExisteException;
}
