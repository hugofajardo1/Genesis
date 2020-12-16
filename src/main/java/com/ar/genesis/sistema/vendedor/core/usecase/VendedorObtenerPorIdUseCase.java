package com.ar.genesis.sistema.vendedor.core.usecase;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorNoExisteException;
import com.ar.genesis.sistema.vendedor.core.input.IVendedorObtenerPorIdInput;
import com.ar.genesis.sistema.vendedor.core.repository.IVendedorObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VendedorObtenerPorIdUseCase implements IVendedorObtenerPorIdInput {

    IVendedorObtenerPorIdRepository miVendedorObtenerPorIdRepository;

    public VendedorObtenerPorIdUseCase(IVendedorObtenerPorIdRepository miVendedorObtenerPorIdRepository) { this.miVendedorObtenerPorIdRepository = miVendedorObtenerPorIdRepository; }

    @Override
    public Vendedor obtenerVendedor(Integer id) throws VendedorNoExisteException {
        Vendedor unVendedor = miVendedorObtenerPorIdRepository.obtenerVendedor(id);
        if(unVendedor==null){
            throw new VendedorNoExisteException();
        }
        return unVendedor;
    }
}
