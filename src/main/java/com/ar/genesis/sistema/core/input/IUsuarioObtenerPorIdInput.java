package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioNoExisteException;

public interface IUsuarioObtenerPorIdInput {
    Usuario obtenerUsuario(Integer id) throws UsuarioNoExisteException;
}
