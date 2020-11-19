package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.repository.IObtenerClienteRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IClienteCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ObtenerClientesRepoImplementacion implements IObtenerClienteRepository {
    @Inject
    IClienteCRUD clienteCRUD;

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteCRUD.findAllByOrderById();
    }
}
