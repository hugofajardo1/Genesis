package com.ar.genesis.sistema.proveedor.persistence.implementation;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.repository.IProveedorObtenerRepository;
import com.ar.genesis.sistema.proveedor.persistence.crud.IProveedorCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ProveedorObtenerRepoImplementacion implements IProveedorObtenerRepository {
    @Inject
    IProveedorCRUD miProveedorCRUD;

    @Override
    public List<Proveedor> obtenerProveedores() {
        return miProveedorCRUD.findAllByOrderById();
    }
}
