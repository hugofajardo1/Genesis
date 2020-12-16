package com.ar.genesis.sistema.proveedor.core.usecase;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.exception.ProveedorNoExisteException;
import com.ar.genesis.sistema.proveedor.core.input.IProveedorObtenerPorIdInput;
import com.ar.genesis.sistema.proveedor.core.repository.IProveedorObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProveedorObtenerPorIdUseCase implements IProveedorObtenerPorIdInput {

    IProveedorObtenerPorIdRepository miProveedorObtenerPorIdRepository;

    public ProveedorObtenerPorIdUseCase(IProveedorObtenerPorIdRepository miProveedorObtenerPorIdRepository) { this.miProveedorObtenerPorIdRepository = miProveedorObtenerPorIdRepository; }

    @Override
    public Proveedor obtenerProveedor(Integer id) throws ProveedorNoExisteException {
        Proveedor unProveedor = miProveedorObtenerPorIdRepository.obtenerProveedor(id);
        if(unProveedor==null){
            throw new ProveedorNoExisteException();
        }
        return unProveedor;
    }
}
