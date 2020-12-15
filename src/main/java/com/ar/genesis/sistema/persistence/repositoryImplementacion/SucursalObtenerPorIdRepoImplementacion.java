package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.repository.ISucursalObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.ISucursalCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SucursalObtenerPorIdRepoImplementacion implements ISucursalObtenerPorIdRepository {
    @Inject
    ISucursalCRUD miSucursalCRUD;

    @Override
    public Sucursal obtenerSucursal(Integer id) { return miSucursalCRUD.findSucursalByIdEquals(id); }
}
