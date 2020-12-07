package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.repository.IUbicacionObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IUbicacionCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UbicacionObtenerPorIdRepoImplementacion implements IUbicacionObtenerPorIdRepository {
    @Inject
    IUbicacionCRUD miUbicacionCRUD;

    @Override
    public Ubicacion obtenerUbicacion(Integer id) { return miUbicacionCRUD.findUbicacionByIdEquals(id); }
}
