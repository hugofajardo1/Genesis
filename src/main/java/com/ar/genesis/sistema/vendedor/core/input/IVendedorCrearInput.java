package com.ar.genesis.sistema.vendedor.core.input;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorExisteException;

public interface IVendedorCrearInput {
    boolean crearVendedor(Vendedor unVendedor) throws VendedorExisteException;
}
