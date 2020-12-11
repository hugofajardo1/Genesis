package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.exception.SucursalExisteException;
import com.ar.genesis.sistema.core.input.ISucursalModificarInput;
import com.ar.genesis.sistema.core.repository.ISucursalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SucursalModificarUseCase implements ISucursalModificarInput {

    ISucursalRepository miSucursalRepository;

    public SucursalModificarUseCase(ISucursalRepository miSucursalRepository) { this.miSucursalRepository = miSucursalRepository; }

    @Override
    public boolean modificarSucursal(Sucursal unaSucursal) throws SucursalExisteException {
        if(miSucursalRepository.existeSucursal(unaSucursal.getNombre())){
            throw new SucursalExisteException();
        }
        return miSucursalRepository.guardarSucursal(unaSucursal);
    }
}
