package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Localidad;

import java.util.List;

public interface IObtenerLocalidadesRepository {
    List<Localidad> obtenerLocalidades();
}