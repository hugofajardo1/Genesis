package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.repository.IObtenerUbicacionesRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IUbicacionCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ObtenerUbicacionesRepoImplmentacion implements IObtenerUbicacionesRepository {
    @Inject
    IUbicacionCRUD ubicacionCRUD;

    @Override
    public List<Ubicacion> obtenerUbicaciones() {
        return ubicacionCRUD.findAllByOrderById();
    }
}
