package com.ar.genesis.sistema.puntoventa.core.repository;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;

import java.util.List;

public interface IPuntoVentaObtenerRepository {
    List<PuntoVenta> obtenerPuntoVentas();
}
