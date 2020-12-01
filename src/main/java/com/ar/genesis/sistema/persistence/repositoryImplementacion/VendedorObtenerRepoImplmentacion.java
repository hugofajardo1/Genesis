package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Vendedor;
import com.ar.genesis.sistema.core.repository.IVendedorObtenerRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IVendedorCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class VendedorObtenerRepoImplmentacion implements IVendedorObtenerRepository {
    @Inject
    IVendedorCRUD miVendedorCRUD;

    @Override
    public List<Vendedor> obtenerVendedores() {
        return miVendedorCRUD.findAllByOrderById();
    }
}
