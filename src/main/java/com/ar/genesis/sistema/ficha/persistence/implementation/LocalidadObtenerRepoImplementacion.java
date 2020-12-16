package com.ar.genesis.sistema.ficha.persistence.implementation;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.repository.ILocalidadObtenerRepository;
import com.ar.genesis.sistema.localidad.persistence.crud.ILocalidadCRUD;
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
