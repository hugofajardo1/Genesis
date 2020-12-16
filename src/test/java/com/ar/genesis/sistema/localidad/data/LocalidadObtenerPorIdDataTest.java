package com.ar.genesis.sistema.localidad.data;

import com.ar.genesis.sistema.ficha.persistence.implementation.LocalidadObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:LocalidadObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:LocalidadObtenerDespues.sql")
})
public class LocalidadObtenerPorIdDataTest {
    @Inject
    LocalidadObtenerPorIdRepoImplementacion miLocalidadObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerLocalidadPorId_DevuelveLocalidad() {
        Assertions.assertNotNull(miLocalidadObtenerPorIdRepoImplementacion.obtenerLocalidad(1));
    }

    @Test
    public void obtenerLocalidadPorId_DevuelveNull() {
        Assertions.assertNull(miLocalidadObtenerPorIdRepoImplementacion.obtenerLocalidad(3));
    }
}
