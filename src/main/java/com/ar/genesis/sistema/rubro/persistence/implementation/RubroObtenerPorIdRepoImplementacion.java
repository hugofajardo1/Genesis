package com.ar.genesis.sistema.rubro.persistence.implementation;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.repository.IRubroObtenerPorIdRepository;
import com.ar.genesis.sistema.rubro.persistence.crud.IRubroCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class RubroObtenerPorIdRepoImplementacion implements IRubroObtenerPorIdRepository {
    @Inject
    IRubroCRUD miRubroCRUD;

    @Override
    public Rubro obtenerRubro(Integer id) { return miRubroCRUD.findRubroByIdEquals(id); }
}
