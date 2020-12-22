package com.ar.genesis.sistema.permisousuario.core.usecase;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioNoExisteException;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioEliminarInput;
import com.ar.genesis.sistema.permisousuario.core.repository.IPermisoUsuarioEliminarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermisoUsuarioEliminarUseCase implements IPermisoUsuarioEliminarInput {

    IPermisoUsuarioEliminarRepository miPermisoUsuarioEliminarRepository;

    public PermisoUsuarioEliminarUseCase(IPermisoUsuarioEliminarRepository miPermisoUsuarioEliminarRepository) {
        this.miPermisoUsuarioEliminarRepository = miPermisoUsuarioEliminarRepository;
    }

    @Override
    public boolean eliminarPermisoUsuario(PermisoUsuario unPermisoUsuario) throws PermisoUsuarioNoExisteException {
        if(!miPermisoUsuarioEliminarRepository.existePermisoUsuario(unPermisoUsuario)){
            throw new PermisoUsuarioNoExisteException();
        }
        return miPermisoUsuarioEliminarRepository.eliminarPermisoUsuario(unPermisoUsuario);
    }
}
