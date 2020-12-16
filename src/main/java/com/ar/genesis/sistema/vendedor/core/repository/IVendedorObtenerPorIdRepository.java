package com.ar.genesis.sistema.vendedor.core.repository;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;

public interface IVendedorObtenerPorIdRepository {
    Vendedor obtenerVendedor(Integer id);
}
