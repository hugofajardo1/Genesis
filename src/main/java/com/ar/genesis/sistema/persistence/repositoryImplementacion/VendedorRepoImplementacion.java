package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Vendedor;
import com.ar.genesis.sistema.core.repository.IVendedorRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IVendedorCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class VendedorRepoImplementacion implements IVendedorRepository {

    @Inject
    IVendedorCRUD miVendedorCRUD;

    @Override
    public boolean existeVendedor(String nombre) { return miVendedorCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarVendedor(Vendedor unVendedor) { return miVendedorCRUD.save(unVendedor).getId()!=null; }
}
