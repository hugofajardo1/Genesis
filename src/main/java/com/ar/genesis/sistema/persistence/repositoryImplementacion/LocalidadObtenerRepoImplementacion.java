package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.repository.ILocalidadObtenerRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ILocalidadCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class LocalidadObtenerRepoImplementacion implements ILocalidadObtenerRepository {
    @Inject
    ILocalidadCRUD miLocalidadCRUD;

    @Override
    public List<Localidad> obtenerLocalidades() {
        return miLocalidadCRUD.findAllByOrderById();
    }
}
