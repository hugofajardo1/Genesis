package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.TipoCliente;
import com.ar.genesis.sistema.core.exception.TipoClienteExisteException;

public interface ICrearTipoClienteInput {

    boolean crearTipoCliente(TipoCliente unTipoCliente) throws TipoClienteExisteException;
}
