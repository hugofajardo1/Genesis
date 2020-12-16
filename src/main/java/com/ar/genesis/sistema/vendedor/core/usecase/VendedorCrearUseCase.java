package com.ar.genesis.sistema.vendedor.core.usecase;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorExisteException;
import com.ar.genesis.sistema.vendedor.core.input.IVendedorCrearInput;
import com.ar.genesis.sistema.vendedor.core.repository.IVendedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VendedorCrearUseCase implements IVendedorCrearInput {

    IVendedorRepository miVendedorRepository;

    public VendedorCrearUseCase(IVendedorRepository miVendedorRepository) { this.miVendedorRepository = miVendedorRepository; }

    @Override
    public boolean crearVendedor(Vendedor unVendedor) throws VendedorExisteException {
        if(miVendedorRepository.existeVendedor(unVendedor.getNombre())){
            throw new VendedorExisteException();
        }
        return miVendedorRepository.guardarVendedor(unVendedor);
    }
}
