package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioExisteException;
import com.ar.genesis.sistema.core.input.IUsuarioModificarInput;
import com.ar.genesis.sistema.core.repository.IUsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioModificarUseCase implements IUsuarioModificarInput {

    IUsuarioRepository miUsuarioRepository;

    public UsuarioModificarUseCase(IUsuarioRepository miUsuarioRepository) { this.miUsuarioRepository = miUsuarioRepository; }

    @Override
    public boolean modificarUsuario(Usuario unUsuario) throws UsuarioExisteException {
        if(miUsuarioRepository.existeUsuario(unUsuario.getNombre())){
            throw new UsuarioExisteException();
        }
        return miUsuarioRepository.guardarUsuario(unUsuario);
    }
}
