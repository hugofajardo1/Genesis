package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Vendedor;
import com.ar.genesis.sistema.core.exception.VendedorExisteException;
import com.ar.genesis.sistema.core.input.IVendedorModificarInput;
import com.ar.genesis.sistema.core.repository.IVendedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VendedorModificarUseCase implements IVendedorModificarInput {

    IVendedorRepository miVendedorRepository;

    public VendedorModificarUseCase(IVendedorRepository miVendedorRepository) { this.miVendedorRepository = miVendedorRepository; }

    @Override
    public boolean modificarVendedor(Vendedor unVendedor) throws VendedorExisteException {
        if(miVendedorRepository.existeVendedor(unVendedor.getNombre())){
            throw new VendedorExisteException();
        }
        return miVendedorRepository.guardarVendedor(unVendedor);
    }
}
