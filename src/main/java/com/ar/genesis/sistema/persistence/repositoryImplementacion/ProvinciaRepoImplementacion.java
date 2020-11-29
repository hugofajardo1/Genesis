package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.repository.IProvinciaRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IProvinciaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ProvinciaRepoImplementacion implements IProvinciaRepository {

    @Inject
    IProvinciaCRUD provinciaCRUD;

    @Override
    public boolean existeProvincia(String nombre) { return provinciaCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarProvincia(Provincia unProvincia) { return provinciaCRUD.save(unProvincia).getId()!=null; }
}
