package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioExisteException;

public interface IUsuarioModificarInput {
    boolean modificarUsuario(Usuario unUsuario) throws UsuarioExisteException;
}
