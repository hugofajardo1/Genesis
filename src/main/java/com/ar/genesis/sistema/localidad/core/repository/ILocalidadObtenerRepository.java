package com.ar.genesis.sistema.localidad.core.repository;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;

import java.util.List;

public interface ILocalidadObtenerRepository {
    List<Localidad> obtenerLocalidades();
}
