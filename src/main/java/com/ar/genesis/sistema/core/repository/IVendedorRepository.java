package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Vendedor;

public interface IVendedorRepository {
    boolean existeVendedor(String nombre);

    boolean guardarVendedor(Vendedor Vendedor);
}
