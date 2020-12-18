package com.ar.genesis.sistema.puntoventa.core.input;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;

import java.util.List;

public interface IPuntoVentaObtenerInput {
    List<PuntoVenta> obtenerPuntoVentas();
}
