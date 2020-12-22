package com.ar.genesis.sistema.permisousuario.core.usecase;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioExisteException;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioModificarInput;
import com.ar.genesis.sistema.permisousuario.core.repository.IPermisoUsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermisoUsuarioModificarUseCase implements IPermisoUsuarioModificarInput {

    IPermisoUsuarioRepository miPermisoUsuarioRepository;

    public PermisoUsuarioModificarUseCase(IPermisoUsuarioRepository miPermisoUsuarioRepository) {
        this.miPermisoUsuarioRepository = miPermisoUsuarioRepository;
    }

    @Override
    public boolean modificarPermisoUsuario(PermisoUsuario unPermisoUsuario) throws PermisoUsuarioExisteException {
        if(miPermisoUsuarioRepository.existePermisoUsuario(unPermisoUsuario)){
            throw new PermisoUsuarioExisteException();
        }
        return miPermisoUsuarioRepository.guardarPermisoUsuario(unPermisoUsuario);
    }
}
