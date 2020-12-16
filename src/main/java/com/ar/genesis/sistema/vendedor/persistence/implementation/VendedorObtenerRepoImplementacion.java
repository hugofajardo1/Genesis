package com.ar.genesis.sistema.vendedor.persistence.implementation;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.repository.IVendedorObtenerRepository;
import com.ar.genesis.sistema.vendedor.persistence.crud.IVendedorCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class VendedorObtenerRepoImplementacion implements IVendedorObtenerRepository {
    @Inject
    IVendedorCRUD miVendedorCRUD;

    @Override
    public List<Vendedor> obtenerVendedores() {
        return miVendedorCRUD.findAllByOrderById();
    }
}
