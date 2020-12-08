package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Proveedor;
import com.ar.genesis.sistema.core.repository.IProveedorObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IProveedorCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ProveedorObtenerPorIdRepoImplementacion implements IProveedorObtenerPorIdRepository {
    @Inject
    IProveedorCRUD miProveedorCRUD;

    @Override
    public Proveedor obtenerProveedor(Integer id) { return miProveedorCRUD.findProveedorByIdEquals(id); }
}
