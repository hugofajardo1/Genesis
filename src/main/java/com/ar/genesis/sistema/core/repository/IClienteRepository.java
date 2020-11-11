package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Cliente;

public interface IClienteRepository {

    boolean existeCliente(String nombre);

    boolean guardarCliente(Cliente unCliente);
}
