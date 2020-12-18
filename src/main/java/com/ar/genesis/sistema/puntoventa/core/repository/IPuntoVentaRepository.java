package com.ar.genesis.sistema.puntoventa.core.repository;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;

public interface IPuntoVentaRepository {
    boolean existePuntoVenta(String nombre);

    boolean guardarPuntoVenta(PuntoVenta unPuntoVenta);
}
