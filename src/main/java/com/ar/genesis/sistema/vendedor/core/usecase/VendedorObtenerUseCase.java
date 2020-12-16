package com.ar.genesis.sistema.vendedor.core.usecase;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.input.IVendedorObtenerInput;
import com.ar.genesis.sistema.vendedor.core.repository.IVendedorObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VendedorObtenerUseCase implements IVendedorObtenerInput {

    IVendedorObtenerRepository miVendedorObtenerRepository;

    public VendedorObtenerUseCase(IVendedorObtenerRepository miVendedorObtenerRepository) { this.miVendedorObtenerRepository = miVendedorObtenerRepository; }

    @Override
    public List<Vendedor> obtenerVendedores() {
        return miVendedorObtenerRepository.obtenerVendedores();
    }
}
