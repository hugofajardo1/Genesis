package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.TipoCliente;

public interface ITipoClienteRepository {
    boolean existeTipoCliente(String nombre);

    boolean guardarTipoCliente(TipoCliente unCliente);
}
