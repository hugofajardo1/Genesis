package com.ar.genesis.sistema.core.input;

import com.ar.genesis.sistema.core.domain.Vendedor;
import com.ar.genesis.sistema.core.exception.VendedorNoExisteException;

public interface IVendedorObtenerPorIdInput {
    Vendedor obtenerVendedor(Integer id) throws VendedorNoExisteException;
}
