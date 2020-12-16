package com.ar.genesis.sistema.subrubro.persistence.implementation;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.core.repository.ISubRubroObtenerRepository;
import com.ar.genesis.sistema.subrubro.persistence.crud.ISubRubroCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SubRubroObtenerRepoImplementacion implements ISubRubroObtenerRepository {
    @Inject
    ISubRubroCRUD miSubRubroCRUD;

    @Override
    public List<SubRubro> obtenerSubRubros() {
        return miSubRubroCRUD.findAllByOrderById();
    }
}
