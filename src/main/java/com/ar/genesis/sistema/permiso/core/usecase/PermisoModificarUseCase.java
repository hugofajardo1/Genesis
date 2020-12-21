package com.ar.genesis.sistema.permiso.core.usecase;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoExisteException;
import com.ar.genesis.sistema.permiso.core.input.IPermisoModificarInput;
import com.ar.genesis.sistema.permiso.core.repository.IPermisoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermisoModificarUseCase implements IPermisoModificarInput {

    IPermisoRepository miPermisoRepository;

    public PermisoModificarUseCase(IPermisoRepository miPermisoRepository) {
        this.miPermisoRepository = miPermisoRepository;
    }

    @Override
    public boolean modificarPermiso(Permiso unPermiso) throws PermisoExisteException {
        if(miPermisoRepository.existePermiso(unPermiso.getNombre())){
            throw new PermisoExisteException();
        }
        return miPermisoRepository.guardarPermiso(unPermiso);
    }
}
