package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.repository.IObtenerRubrosRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IRubroCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ObtenerRubrosRepoImplmentacion implements IObtenerRubrosRepository {
    @Inject
    IRubroCRUD rubroCRUD;

    @Override
    public List<Rubro> obtenerRubros() {
        return rubroCRUD.findAllByOrderById();
    }
}
