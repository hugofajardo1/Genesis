package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Cliente;

import java.util.List;

public interface IObtenerClienteRepository {
    List<Cliente> obtenerClientes();
}
