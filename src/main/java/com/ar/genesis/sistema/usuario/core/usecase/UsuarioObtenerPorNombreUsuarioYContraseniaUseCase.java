package com.ar.genesis.sistema.usuario.core.usecase;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.usuario.core.input.IUsuarioObtenerPorNombreUsuarioYContraseniaInput;
import com.ar.genesis.sistema.usuario.core.repository.IUsuarioObtenerPorNombreUsuarioYContraseniaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioObtenerPorNombreUsuarioYContraseniaUseCase implements IUsuarioObtenerPorNombreUsuarioYContraseniaInput {

    IUsuarioObtenerPorNombreUsuarioYContraseniaRepository miUsuarioObtenerPorNombreUsuarioYContraseniaRepository;

    public UsuarioObtenerPorNombreUsuarioYContraseniaUseCase(IUsuarioObtenerPorNombreUsuarioYContraseniaRepository miUsuarioObtenerPorNombreUsuarioYContraseniaRepository) { this.miUsuarioObtenerPorNombreUsuarioYContraseniaRepository = miUsuarioObtenerPorNombreUsuarioYContraseniaRepository; }

    @Override
    public Usuario obtenerUsuario(String nombreUsuario, String contrasenia) throws UsuarioNoExisteException {
        Usuario unUsuario = miUsuarioObtenerPorNombreUsuarioYContraseniaRepository.obtenerUsuario(nombreUsuario, contrasenia);
        if(unUsuario==null){
            throw new UsuarioNoExisteException();
        }
        return unUsuario;
    }
}
