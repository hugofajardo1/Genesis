package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.input.IObtenerClienteInput;
import com.ar.genesis.sistema.core.repository.IObtenerClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObtenerClientesUseCase implements IObtenerClienteInput {

    IObtenerClienteRepository iObtenerClienteRepository;

    public ObtenerClientesUseCase(IObtenerClienteRepository iObtenerClienteRepository) {
        this.iObtenerClienteRepository = iObtenerClienteRepository;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return iObtenerClienteRepository.obtenerClientes();
    }
}
