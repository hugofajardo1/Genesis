package com.ar.genesis.sistema.permisousuario.core.usecase;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioObtenerInput;
import com.ar.genesis.sistema.permisousuario.core.repository.IPermisoUsuarioObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermisoUsuarioObtenerUseCase implements IPermisoUsuarioObtenerInput {

    IPermisoUsuarioObtenerRepository miPermisoUsuarioObtenerRepository;

    public PermisoUsuarioObtenerUseCase(IPermisoUsuarioObtenerRepository miPermisoUsuarioObtenerRepository) { this.miPermisoUsuarioObtenerRepository = miPermisoUsuarioObtenerRepository; }

    @Override
    public List<PermisoUsuario> obtenerPermisoUsuarios() {
        return miPermisoUsuarioObtenerRepository.obtenerPermisoUsuarios();
    }
}
