package com.ar.genesis.sistema.localidad.core.repository;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;

public interface ILocalidadRepository {
    boolean existeLocalidad(String nombre);

    boolean guardarLocalidad(Localidad localidad);
}
