package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.core.input.IUsuarioObtenerPorIdInput;
import com.ar.genesis.sistema.core.repository.IUsuarioObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioObtenerPorIdUseCase implements IUsuarioObtenerPorIdInput {

    IUsuarioObtenerPorIdRepository miUsuarioObtenerPorIdRepository;

    public UsuarioObtenerPorIdUseCase(IUsuarioObtenerPorIdRepository miUsuarioObtenerPorIdRepository) { this.miUsuarioObtenerPorIdRepository = miUsuarioObtenerPorIdRepository; }

    @Override
    public Usuario obtenerUsuario(Integer id) throws UsuarioNoExisteException {
        Usuario unUsuario = miUsuarioObtenerPorIdRepository.obtenerUsuario(id);
        if(unUsuario==null){
            throw new UsuarioNoExisteException();
        }
        return unUsuario;
    }
}
