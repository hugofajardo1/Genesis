package com.ar.genesis.sistema.proveedor.persistence.implementation;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.repository.IProveedorObtenerPorIdRepository;
import com.ar.genesis.sistema.proveedor.persistence.crud.IProveedorCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ProveedorObtenerPorIdRepoImplementacion implements IProveedorObtenerPorIdRepository {
    @Inject
    IProveedorCRUD miProveedorCRUD;

    @Override
    public Proveedor obtenerProveedor(Integer id) { return miProveedorCRUD.findProveedorByIdEquals(id); }
}
