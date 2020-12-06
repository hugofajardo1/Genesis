package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioExisteException;

public interface IUsuarioCrearInput {
    boolean crearUsuario(Usuario unUsuario) throws UsuarioExisteException;
}
