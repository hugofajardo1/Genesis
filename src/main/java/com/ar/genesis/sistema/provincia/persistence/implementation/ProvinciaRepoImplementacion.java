package com.ar.genesis.sistema.provincia.persistence.implementation;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.repository.IProvinciaRepository;
import com.ar.genesis.sistema.provincia.persistence.crud.IProvinciaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ProvinciaRepoImplementacion implements IProvinciaRepository {

    @Inject
    IProvinciaCRUD miProvinciaCRUD;

    @Override
    public boolean existeProvincia(String nombre) { return miProvinciaCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarProvincia(Provincia unaProvincia) { return miProvinciaCRUD.save(unaProvincia).getId()!=null; }
}
