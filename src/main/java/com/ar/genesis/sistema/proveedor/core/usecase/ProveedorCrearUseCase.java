package com.ar.genesis.sistema.proveedor.core.usecase;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.exception.ProveedorExisteException;
import com.ar.genesis.sistema.proveedor.core.input.IProveedorCrearInput;
import com.ar.genesis.sistema.proveedor.core.repository.IProveedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProveedorCrearUseCase implements IProveedorCrearInput {

    IProveedorRepository miProveedorRepository;

    public ProveedorCrearUseCase(IProveedorRepository miProveedorRepository) { this.miProveedorRepository = miProveedorRepository; }

    @Override
    public boolean crearProveedor(Proveedor unProveedor) throws ProveedorExisteException {
        if(miProveedorRepository.existeProveedor(unProveedor.getNombre())){
            throw new ProveedorExisteException();
        }
        return miProveedorRepository.guardarProveedor(unProveedor);
    }
}
