package com.ar.genesis.sistema.permiso.core.usecase;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoExisteException;
import com.ar.genesis.sistema.permiso.core.input.IPermisoCrearInput;
import com.ar.genesis.sistema.permiso.core.repository.IPermisoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermisoCrearUseCase implements IPermisoCrearInput {

    IPermisoRepository miPermisoRepository;

    public PermisoCrearUseCase(IPermisoRepository miPermisoRepository) {
        this.miPermisoRepository = miPermisoRepository;
    }

    @Override
    public boolean crearPermiso(Permiso unPermiso) throws PermisoExisteException {
        if(miPermisoRepository.existePermiso(unPermiso.getNombre())){
            throw new PermisoExisteException();
        }
        return miPermisoRepository.guardarPermiso(unPermiso);
    }
}
