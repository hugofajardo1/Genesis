package com.ar.genesis.sistema.localidadTest.data;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.ficha.persistence.implementation.LocalidadRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:LocalidadCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:LocalidadCrearDespues.sql")
})
public class LocalidadCrearDataTest {
    @Inject
    LocalidadRepoImplementacion miLocalidadRepoImplementacion;

    @Test
    public void guardarLocalidad_LocalidadGuardado_devuelveTrue() {
        Localidad unaLocalidad = Localidad.instancia(null, "Localidad 1");
        boolean resultado = miLocalidadRepoImplementacion.guardarLocalidad(unaLocalidad);
        Assertions.assertTrue(resultado);
    }

}
