package com.ar.genesis.sistema.permisousuario.core.usecase;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioNoExisteException;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioObtenerPorIdInput;
import com.ar.genesis.sistema.permisousuario.core.repository.IPermisoUsuarioObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermisoUsuarioObtenerPorIdUseCase implements IPermisoUsuarioObtenerPorIdInput {

    IPermisoUsuarioObtenerPorIdRepository miPermisoUsuarioObtenerPorIdRepository;

    public PermisoUsuarioObtenerPorIdUseCase(IPermisoUsuarioObtenerPorIdRepository miPermisoUsuarioObtenerPorIdRepository) { this.miPermisoUsuarioObtenerPorIdRepository = miPermisoUsuarioObtenerPorIdRepository; }

    @Override
    public PermisoUsuario obtenerPermisoUsuario(Integer id) throws PermisoUsuarioNoExisteException {
        PermisoUsuario unPermisoUsuario = miPermisoUsuarioObtenerPorIdRepository.obtenerPermisoUsuario(id);
        if(unPermisoUsuario==null){
            throw new PermisoUsuarioNoExisteException();
        }
        return unPermisoUsuario;
    }
}
