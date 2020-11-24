package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.repository.IObtenerSubRubrosRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ISubRubroCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ObtenerSubRubrosRepoImplmentacion implements IObtenerSubRubrosRepository {
    @Inject
    ISubRubroCRUD subRubroCRUD;

    @Override
    public List<SubRubro> obtenerSubRubros() {
        return subRubroCRUD.findAllByOrderById();
    }
}
