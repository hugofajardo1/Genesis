package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.repository.ISubRubroObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ISubRubroCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SubRubroObtenerPorIdRepoImplementacion implements ISubRubroObtenerPorIdRepository {
    @Inject
    ISubRubroCRUD miSubRubroCRUD;

    @Override
    public SubRubro obtenerSubRubro(Integer id) { return miSubRubroCRUD.findSubRubroByIdEquals(id); }
}
