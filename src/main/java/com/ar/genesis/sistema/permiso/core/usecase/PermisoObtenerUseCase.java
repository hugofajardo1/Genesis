package com.ar.genesis.sistema.permiso.core.usecase;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.input.IPermisoObtenerInput;
import com.ar.genesis.sistema.permiso.core.repository.IPermisoObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermisoObtenerUseCase implements IPermisoObtenerInput {

    IPermisoObtenerRepository miPermisoObtenerRepository;

    public PermisoObtenerUseCase(IPermisoObtenerRepository miPermisoObtenerRepository) { this.miPermisoObtenerRepository = miPermisoObtenerRepository; }

    @Override
    public List<Permiso> obtenerPermisos() {
        return miPermisoObtenerRepository.obtenerPermisos();
    }
}
