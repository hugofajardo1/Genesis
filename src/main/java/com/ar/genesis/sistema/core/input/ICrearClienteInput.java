package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.exception.ClienteExisteException;

public interface ICrearClienteInput {

    boolean crearCliente(Cliente unCliente) throws ClienteExisteException;
}
