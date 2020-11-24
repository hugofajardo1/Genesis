package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.repository.IRubroRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IRubroCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class RubroRepoImplementacion implements IRubroRepository {

    @Inject
    IRubroCRUD rubroCRUD;

    @Override
    public boolean existeRubro(String nombre) { return rubroCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarRubro(Rubro unRubro) { return rubroCRUD.save(unRubro).getId()!=null; }
}
