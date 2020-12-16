package com.ar.genesis.sistema.vendedor.core.input;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorExisteException;

public interface IVendedorModificarInput {
    boolean modificarVendedor(Vendedor unVendedor) throws VendedorExisteException;
}
