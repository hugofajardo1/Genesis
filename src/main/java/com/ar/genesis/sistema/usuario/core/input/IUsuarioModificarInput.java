package com.ar.genesis.sistema.usuario.core.input;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioExisteException;

public interface IUsuarioModificarInput {
    boolean modificarUsuario(Usuario unUsuario) throws UsuarioExisteException;
}
