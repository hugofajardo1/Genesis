package com.ar.genesis.sistema.permiso.core.usecase;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoNoExisteException;
import com.ar.genesis.sistema.permiso.core.input.IPermisoObtenerPorIdInput;
import com.ar.genesis.sistema.permiso.core.repository.IPermisoObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermisoObtenerPorIdUseCase implements IPermisoObtenerPorIdInput {

    IPermisoObtenerPorIdRepository miPermisoObtenerPorIdRepository;

    public PermisoObtenerPorIdUseCase(IPermisoObtenerPorIdRepository miPermisoObtenerPorIdRepository) { this.miPermisoObtenerPorIdRepository = miPermisoObtenerPorIdRepository; }

    @Override
    public Permiso obtenerPermiso(Integer id) throws PermisoNoExisteException {
        Permiso unPermiso = miPermisoObtenerPorIdRepository.obtenerPermiso(id);
        if(unPermiso==null){
            throw new PermisoNoExisteException();
        }
        return unPermiso;
    }
}
