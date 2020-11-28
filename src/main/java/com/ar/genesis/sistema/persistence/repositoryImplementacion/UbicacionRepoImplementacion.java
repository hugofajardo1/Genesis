package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.repository.IUbicacionRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IUbicacionCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UbicacionRepoImplementacion implements IUbicacionRepository {

    @Inject
    IUbicacionCRUD ubicacionCRUD;

    @Override
    public boolean existeUbicacion(String nombre) { return ubicacionCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarUbicacion(Ubicacion ubicacion) { return ubicacionCRUD.save(ubicacion).getId()!=null; }
}
