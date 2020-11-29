package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.UbicacionRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearUbicacionAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearUbicacionDespues.sql")
})
public class UbicacionCrearDataTest {

    @Inject
    UbicacionRepoImplementacion miUbicacionRepoImplementacion;

    @Test
    public void guardarUbicacion_UbicacionGuardado_devuelveTrue() {
        Ubicacion unaUbicacion = Ubicacion.instancia(null, "Ubicacion 1");
        boolean resultado = miUbicacionRepoImplementacion.guardarUbicacion(unaUbicacion);
        Assertions.assertTrue(resultado);
    }

}
