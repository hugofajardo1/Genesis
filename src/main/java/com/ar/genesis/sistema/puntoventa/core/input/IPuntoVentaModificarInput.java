package com.ar.genesis.sistema.puntoventa.core.input;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaExisteException;

public interface IPuntoVentaModificarInput {
    boolean modificarPuntoVenta(PuntoVenta unPuntoVenta) throws PuntoVentaExisteException;
}
