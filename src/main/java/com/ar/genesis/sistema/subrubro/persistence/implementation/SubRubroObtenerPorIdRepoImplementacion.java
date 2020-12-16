package com.ar.genesis.sistema.subrubro.persistence.implementation;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.core.repository.ISubRubroObtenerPorIdRepository;
import com.ar.genesis.sistema.subrubro.persistence.crud.ISubRubroCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SubRubroObtenerPorIdRepoImplementacion implements ISubRubroObtenerPorIdRepository {
    @Inject
    ISubRubroCRUD miSubRubroCRUD;

    @Override
    public SubRubro obtenerSubRubro(Integer id) { return miSubRubroCRUD.findSubRubroByIdEquals(id); }
}
