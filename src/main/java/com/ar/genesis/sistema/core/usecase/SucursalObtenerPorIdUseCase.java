package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.exception.SucursalNoExisteException;
import com.ar.genesis.sistema.core.input.ISucursalObtenerPorIdInput;
import com.ar.genesis.sistema.core.repository.ISucursalObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SucursalObtenerPorIdUseCase implements ISucursalObtenerPorIdInput {

    ISucursalObtenerPorIdRepository miSucursalObtenerPorIdRepository;

    public SucursalObtenerPorIdUseCase(ISucursalObtenerPorIdRepository miSucursalObtenerPorIdRepository) { this.miSucursalObtenerPorIdRepository = miSucursalObtenerPorIdRepository; }

    @Override
    public Sucursal obtenerSucursal(Integer id) throws SucursalNoExisteException {
        Sucursal unaSucursal = miSucursalObtenerPorIdRepository.obtenerSucursal(id);
        if(unaSucursal==null){
            throw new SucursalNoExisteException();
        }
        return unaSucursal;
    }
}
