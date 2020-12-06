package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.input.IUsuarioObtenerInput;
import com.ar.genesis.sistema.core.repository.IUsuarioObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioObtenerUseCase implements IUsuarioObtenerInput {

    IUsuarioObtenerRepository miUsuarioObtenerRepository;

    public UsuarioObtenerUseCase(IUsuarioObtenerRepository miUsuarioObtenerRepository) { this.miUsuarioObtenerRepository = miUsuarioObtenerRepository; }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return miUsuarioObtenerRepository.obtenerUsuarios();
    }
}
