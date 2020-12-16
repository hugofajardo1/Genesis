package com.ar.genesis.sistema.ficha.core.repository;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;

import java.util.List;

public interface IFichaObtenerRepository {
    List<Ficha> obtenerFichas();
}
