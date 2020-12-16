package com.ar.genesis.sistema.sucursal.persistence.implementation;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.sucursal.core.repository.ISucursalObtenerPorIdRepository;
import com.ar.genesis.sistema.sucursal.persistence.crud.ISucursalCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SucursalObtenerPorIdRepoImplementacion implements ISucursalObtenerPorIdRepository {
    @Inject
    ISucursalCRUD miSucursalCRUD;

    @Override
    public Sucursal obtenerSucursal(Integer id) { return miSucursalCRUD.findSucursalByIdEquals(id); }
}
