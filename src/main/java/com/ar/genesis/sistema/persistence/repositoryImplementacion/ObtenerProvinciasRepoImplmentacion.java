package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.repository.IObtenerProvinciasRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IProvinciaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ObtenerProvinciasRepoImplmentacion implements IObtenerProvinciasRepository {
    @Inject
    IProvinciaCRUD miProvinciaCRUD;

    @Override
    public List<Provincia> obtenerProvincias() {
        return miProvinciaCRUD.findAllByOrderById();
    }
}
