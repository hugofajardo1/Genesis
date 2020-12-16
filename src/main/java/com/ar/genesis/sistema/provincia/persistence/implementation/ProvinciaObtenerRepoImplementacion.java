package com.ar.genesis.sistema.provincia.persistence.implementation;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.repository.IProvinciaObtenerRepository;
import com.ar.genesis.sistema.provincia.persistence.crud.IProvinciaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ProvinciaObtenerRepoImplementacion implements IProvinciaObtenerRepository {
    @Inject
    IProvinciaCRUD miProvinciaCRUD;

    @Override
    public List<Provincia> obtenerProvincias() {
        return miProvinciaCRUD.findAllByOrderById();
    }
}
