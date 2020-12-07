package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Vendedor;
import com.ar.genesis.sistema.core.repository.IVendedorObtenerPorIdRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IVendedorCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class VendedorObtenerPorIdRepoImplementacion implements IVendedorObtenerPorIdRepository {
    @Inject
    IVendedorCRUD miVendedorCRUD;

    @Override
    public Vendedor obtenerVendedor(Integer id) { return miVendedorCRUD.findVendedorByIdEquals(id); }
}
