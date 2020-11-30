package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.repository.ISubRubroObtenerRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ISubRubroCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SubRubroObtenerRepoImplmentacion implements ISubRubroObtenerRepository {
    @Inject
    ISubRubroCRUD miSubRubroCRUD;

    @Override
    public List<SubRubro> obtenerSubRubros() {
        return miSubRubroCRUD.findAllByOrderById();
    }
}
