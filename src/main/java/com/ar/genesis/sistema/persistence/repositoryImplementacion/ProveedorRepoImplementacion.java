package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Proveedor;
import com.ar.genesis.sistema.core.repository.IProveedorRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IProveedorCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ProveedorRepoImplementacion implements IProveedorRepository {

    @Inject
    IProveedorCRUD miProveedorCRUD;

    @Override
    public boolean existeProveedor(String nombre) { return miProveedorCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarProveedor(Proveedor unProveedor) { return miProveedorCRUD.save(unProveedor).getId()!=null; }
}
