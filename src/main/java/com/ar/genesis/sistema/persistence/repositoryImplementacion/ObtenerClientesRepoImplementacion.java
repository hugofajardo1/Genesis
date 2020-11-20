package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.repository.IObtenerClientesRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IClienteCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ObtenerClientesRepoImplementacion implements IObtenerClientesRepository {
    @Inject
    IClienteCRUD clienteCRUD;

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteCRUD.findAllByOrderById();
    }
}
