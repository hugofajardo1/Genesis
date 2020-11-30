package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.repository.IProvinciaRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IProvinciaCRUD;
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
