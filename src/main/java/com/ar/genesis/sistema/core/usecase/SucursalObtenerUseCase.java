package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.input.ISucursalObtenerInput;
import com.ar.genesis.sistema.core.repository.ISucursalObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SucursalObtenerUseCase implements ISucursalObtenerInput {

    ISucursalObtenerRepository miSucursalObtenerRepository;

    public SucursalObtenerUseCase(ISucursalObtenerRepository miSucursalObtenerRepository) { this.miSucursalObtenerRepository = miSucursalObtenerRepository; }

    @Override
    public List<Sucursal> obtenerSucursales() {
        return miSucursalObtenerRepository.obtenerSucursales();
    }
}
