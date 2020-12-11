package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.repository.ISucursalObtenerRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ISucursalCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SucursalObtenerRepoImplementacion implements ISucursalObtenerRepository {
    @Inject
    ISucursalCRUD miSucursalCRUD;

    @Override
    public List<Sucursal> obtenerSucursales() {
        return miSucursalCRUD.findAllByOrderById();
    }
}
