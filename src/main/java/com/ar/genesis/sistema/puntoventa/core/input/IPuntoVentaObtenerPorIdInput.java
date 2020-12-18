package com.ar.genesis.sistema.puntoventa.core.input;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaNoExisteException;

public interface IPuntoVentaObtenerPorIdInput {
    PuntoVenta obtenerPuntoVenta(Integer id) throws PuntoVentaNoExisteException;
}
