package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.exception.SucursalExisteException;
import com.ar.genesis.sistema.core.input.ISucursalCrearInput;
import com.ar.genesis.sistema.core.repository.ISucursalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SucursalCrearUseCase implements ISucursalCrearInput {

    ISucursalRepository miSucursalRepository;

    public SucursalCrearUseCase(ISucursalRepository miSucursalRepository) { this.miSucursalRepository = miSucursalRepository; }

    @Override
    public boolean crearSucursal(Sucursal unaSucursal) throws SucursalExisteException {
        if(miSucursalRepository.existeSucursal(unaSucursal.getNombre())){
            throw new SucursalExisteException();
        }
        return miSucursalRepository.guardarSucursal(unaSucursal);
    }
}
