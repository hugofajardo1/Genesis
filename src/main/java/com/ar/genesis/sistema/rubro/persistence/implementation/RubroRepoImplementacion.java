package com.ar.genesis.sistema.rubro.persistence.implementation;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.repository.IRubroRepository;
import com.ar.genesis.sistema.rubro.persistence.crud.IRubroCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class RubroRepoImplementacion implements IRubroRepository {

    @Inject
    IRubroCRUD miRubroCRUD;

    @Override
    public boolean existeRubro(String nombre) { return miRubroCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarRubro(Rubro unRubro) { return miRubroCRUD.save(unRubro).getId()!=null; }
}
