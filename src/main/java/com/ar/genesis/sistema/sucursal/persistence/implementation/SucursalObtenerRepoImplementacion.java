package com.ar.genesis.sistema.sucursal.persistence.implementation;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.sucursal.core.repository.ISucursalObtenerRepository;
import com.ar.genesis.sistema.sucursal.persistence.crud.ISucursalCRUD;
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
