package com.ar.genesis.sistema.ubicacion.persistence.implementation;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.repository.IUbicacionObtenerRepository;
import com.ar.genesis.sistema.ubicacion.persistence.crud.IUbicacionCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UbicacionObtenerRepoImplementacion implements IUbicacionObtenerRepository {
    @Inject
    IUbicacionCRUD miUbicacionCRUD;

    @Override
    public List<Ubicacion> obtenerUbicaciones() {
        return miUbicacionCRUD.findAllByOrderById();
    }
}
