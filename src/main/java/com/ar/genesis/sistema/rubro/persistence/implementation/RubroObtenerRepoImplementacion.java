package com.ar.genesis.sistema.rubro.persistence.implementation;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.repository.IRubroObtenerRepository;
import com.ar.genesis.sistema.rubro.persistence.crud.IRubroCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RubroObtenerRepoImplementacion implements IRubroObtenerRepository {
    @Inject
    IRubroCRUD miRubroCRUD;

    @Override
    public List<Rubro> obtenerRubros() {
        return miRubroCRUD.findAllByOrderById();
    }
}
