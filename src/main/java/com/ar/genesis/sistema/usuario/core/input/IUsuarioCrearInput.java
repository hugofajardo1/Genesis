package com.ar.genesis.sistema.usuario.core.input;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioExisteException;

public interface IUsuarioCrearInput {
    boolean crearUsuario(Usuario unUsuario) throws UsuarioExisteException;
}
