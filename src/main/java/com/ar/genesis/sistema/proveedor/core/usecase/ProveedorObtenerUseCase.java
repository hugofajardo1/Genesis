package com.ar.genesis.sistema.proveedor.core.usecase;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.input.IProveedorObtenerInput;
import com.ar.genesis.sistema.proveedor.core.repository.IProveedorObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProveedorObtenerUseCase implements IProveedorObtenerInput {

    IProveedorObtenerRepository miProveedorObtenerRepository;

    public ProveedorObtenerUseCase(IProveedorObtenerRepository miProveedorObtenerRepository) { this.miProveedorObtenerRepository = miProveedorObtenerRepository; }

    @Override
    public List<Proveedor> obtenerProveedores() {
        return miProveedorObtenerRepository.obtenerProveedores();
    }
}
