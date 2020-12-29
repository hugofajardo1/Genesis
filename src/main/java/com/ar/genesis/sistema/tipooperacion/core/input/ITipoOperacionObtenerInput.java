package com.ar.genesis.sistema.tipooperacion.core.input;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;

import java.util.List;

public interface ITipoOperacionObtenerInput {
    List<TipoOperacion> obtenerTipoOperaciones();
}
