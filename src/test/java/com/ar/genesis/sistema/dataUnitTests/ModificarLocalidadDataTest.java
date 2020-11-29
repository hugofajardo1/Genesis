package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.LocalidadRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:modificarLocalidadAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:modificarLocalidadDespues.sql")
})
public class ModificarLocalidadDataTest {
    @Inject
    LocalidadRepoImplementacion localidadRepoImplementacion;

    @Test
    public void guardarLocalidad_LocalidadGuardado_devuelveTrue() {
        Localidad unaLocalidad = Localidad.instancia(1, "Localidad 1");
        boolean resultado = localidadRepoImplementacion.guardarLocalidad(unaLocalidad);
        Assertions.assertTrue(resultado);
    }
}
