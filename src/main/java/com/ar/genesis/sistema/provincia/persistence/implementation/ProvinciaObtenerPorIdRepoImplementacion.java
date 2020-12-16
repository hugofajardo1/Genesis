package com.ar.genesis.sistema.provincia.persistence.implementation;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.repository.IProvinciaObtenerPorIdRepository;
import com.ar.genesis.sistema.provincia.persistence.crud.IProvinciaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ProvinciaObtenerPorIdRepoImplementacion implements IProvinciaObtenerPorIdRepository {
    @Inject
    IProvinciaCRUD miProvinciaCRUD;

    @Override
    public Provincia obtenerProvincia(Integer id) { return miProvinciaCRUD.findProvinciaByIdEquals(id); }
}
