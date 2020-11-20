package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.input.IObtenerClientesInput;
import com.ar.genesis.sistema.core.repository.IObtenerClientesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObtenerClientesUseCase implements IObtenerClientesInput {

    IObtenerClientesRepository iObtenerClientesRepository;

    public ObtenerClientesUseCase(IObtenerClientesRepository iObtenerClientesRepository) {
        this.iObtenerClientesRepository = iObtenerClientesRepository;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return iObtenerClientesRepository.obtenerClientes();
    }
}
