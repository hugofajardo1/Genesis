package com.ar.genesis.sistema.ubicacion.persistence.implementation;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.repository.IUbicacionObtenerPorIdRepository;
import com.ar.genesis.sistema.ubicacion.persistence.crud.IUbicacionCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UbicacionObtenerPorIdRepoImplementacion implements IUbicacionObtenerPorIdRepository {
    @Inject
    IUbicacionCRUD miUbicacionCRUD;

    @Override
    public Ubicacion obtenerUbicacion(Integer id) { return miUbicacionCRUD.findUbicacionByIdEquals(id); }
}
