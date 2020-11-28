package com.ar.genesis.sistema.core.repository;

import com.ar.genesis.sistema.core.domain.Localidad;

public interface ILocalidadRepository {
    boolean existeLocalidad(String nombre);

    boolean guardarLocalidad(Localidad localidad);
}
