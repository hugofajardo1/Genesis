package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Vendedor;
import com.ar.genesis.sistema.core.exception.VendedorExisteException;
import com.ar.genesis.sistema.core.input.IVendedorCrearInput;
import com.ar.genesis.sistema.core.repository.IVendedorRepository;
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
