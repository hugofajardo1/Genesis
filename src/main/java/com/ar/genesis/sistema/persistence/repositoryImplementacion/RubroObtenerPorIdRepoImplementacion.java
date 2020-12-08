package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.repository.IRubroObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IRubroCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class RubroObtenerPorIdRepoImplementacion implements IRubroObtenerPorIdRepository {
    @Inject
    IRubroCRUD miRubroCRUD;

    @Override
    public Rubro obtenerRubro(Integer id) { return miRubroCRUD.findRubroByIdEquals(id); }
}
