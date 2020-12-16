package com.ar.genesis.sistema.vendedor.core.repository;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;

public interface IVendedorRepository {
    boolean existeVendedor(String nombre);

    boolean guardarVendedor(Vendedor Vendedor);
}
