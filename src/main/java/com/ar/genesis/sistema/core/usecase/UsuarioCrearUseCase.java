package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioExisteException;
import com.ar.genesis.sistema.core.input.IUsuarioCrearInput;
import com.ar.genesis.sistema.core.repository.IUsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioCrearUseCase implements IUsuarioCrearInput {

    IUsuarioRepository miUsuarioRepository;

    public UsuarioCrearUseCase(IUsuarioRepository miUsuarioRepository) { this.miUsuarioRepository = miUsuarioRepository; }

    @Override
    public boolean crearUsuario(Usuario unUsuario) throws UsuarioExisteException {
        if(miUsuarioRepository.existeUsuario(unUsuario.getNombre())){
            throw new UsuarioExisteException();
        }
        return miUsuarioRepository.guardarUsuario(unUsuario);
    }
}
