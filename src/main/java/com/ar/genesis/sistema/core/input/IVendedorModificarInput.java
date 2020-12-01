package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Vendedor;
import com.ar.genesis.sistema.core.exception.VendedorExisteException;

public interface IVendedorModificarInput {

    boolean modificarVendedor(Vendedor unVendedor) throws VendedorExisteException;
}
