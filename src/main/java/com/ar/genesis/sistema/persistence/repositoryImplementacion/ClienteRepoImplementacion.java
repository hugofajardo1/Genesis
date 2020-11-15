package com.ar.genesis.sistema.persistence.repositoryImplementacion;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.repository.IClienteRepository;
import com.ar.genesis.sistema.persistence.repositoryCRUD.IClienteCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ClienteRepoImplementacion implements IClienteRepository {

    @Inject
    IClienteCRUD clienteCRUD;

    @Override
    public boolean existeCliente(String nombre) {
        return clienteCRUD.existsByNombre(nombre);
    }

    @Override
    public boolean guardarCliente(Cliente unCliente) {
        return clienteCRUD.save(unCliente).getId()!=null;
    }
}