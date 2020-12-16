package com.ar.genesis.sistema.vendedor.core.repository;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;

import java.util.List;

public interface IVendedorObtenerRepository {
    List<Vendedor> obtenerVendedores();
}
