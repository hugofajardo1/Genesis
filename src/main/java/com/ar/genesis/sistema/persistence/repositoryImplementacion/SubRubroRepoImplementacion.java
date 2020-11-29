package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.repository.ISubRubroRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ISubRubroCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SubRubroRepoImplementacion implements ISubRubroRepository {

    @Inject
    ISubRubroCRUD miRubroCRUD;

    @Override
    public boolean existeSubRubro(String nombre) { return miRubroCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarSubRubro(SubRubro unSubRubro) { return miRubroCRUD.save(unSubRubro).getId()!=null; }
}

