package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Vendedor;

public interface IVendedorObtenerPorIdRepository {
    Vendedor obtenerVendedor(Integer id);
}
