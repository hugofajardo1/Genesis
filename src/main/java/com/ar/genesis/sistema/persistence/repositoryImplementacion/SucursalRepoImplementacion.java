package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.repository.ISucursalRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ISucursalCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SucursalRepoImplementacion implements ISucursalRepository {

    @Inject
    ISucursalCRUD miSucursalCRUD;

    @Override
    public boolean existeSucursal(String nombre) { return miSucursalCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarSucursal(Sucursal unaSucursal) { return miSucursalCRUD.save(unaSucursal).getId()!=null; }
}
