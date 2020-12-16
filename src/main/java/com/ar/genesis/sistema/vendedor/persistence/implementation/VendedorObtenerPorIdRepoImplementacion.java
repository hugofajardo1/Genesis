package com.ar.genesis.sistema.vendedor.persistence.implementation;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.repository.IVendedorObtenerPorIdRepository;
import com.ar.genesis.sistema.vendedor.persistence.crud.IVendedorCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class VendedorObtenerPorIdRepoImplementacion implements IVendedorObtenerPorIdRepository {
    @Inject
    IVendedorCRUD miVendedorCRUD;

    @Override
    public Vendedor obtenerVendedor(Integer id) { return miVendedorCRUD.findVendedorByIdEquals(id); }
}
