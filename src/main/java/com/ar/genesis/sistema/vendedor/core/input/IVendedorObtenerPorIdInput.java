package com.ar.genesis.sistema.vendedor.core.input;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorNoExisteException;

public interface IVendedorObtenerPorIdInput {
    Vendedor obtenerVendedor(Integer id) throws VendedorNoExisteException;
}
