package com.ar.genesis.sistema.permiso.persistence.implementation;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.repository.IPermisoObtenerRepository;
import com.ar.genesis.sistema.permiso.persistence.crud.IPermisoCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PermisoObtenerRepoImplementacion implements IPermisoObtenerRepository {
    @Inject
    IPermisoCRUD miPermisoCRUD;

    @Override
    public List<Permiso> obtenerPermisos() {
        return miPermisoCRUD.findAllByOrderById();
    }
}
