package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Proveedor;
import com.ar.genesis.sistema.core.repository.IProveedorObtenerRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IProveedorCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ProveedorObtenerRepoImplmentacion implements IProveedorObtenerRepository {
    @Inject
    IProveedorCRUD miProveedorCRUD;

    @Override
    public List<Proveedor> obtenerProveedores() {
        return miProveedorCRUD.findAllByOrderById();
    }
}
