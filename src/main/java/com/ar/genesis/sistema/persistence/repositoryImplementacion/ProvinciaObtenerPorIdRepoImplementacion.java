package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.repository.IProvinciaObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IProvinciaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ProvinciaObtenerPorIdRepoImplementacion implements IProvinciaObtenerPorIdRepository {
    @Inject
    IProvinciaCRUD miProvinciaCRUD;

    @Override
    public Provincia obtenerProvincia(Integer id) { return miProvinciaCRUD.findProvinciaByIdEquals(id); }
}
