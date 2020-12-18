package com.ar.genesis.sistema.puntoventa.core.repository;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;

public interface IPuntoVentaObtenerPorIdRepository {
    PuntoVenta obtenerPuntoVenta(Integer id);
}
