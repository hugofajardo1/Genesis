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
public class CrearUbicacionDataTest {

    @Inject
    UbicacionRepoImplementacion ubicacionRepoImplementacion;

    @Test
    public void guardarUbicacion_UbicacionGuardado_devuelveTrue() {
        Ubicacion ubicacion = Ubicacion.instancia(null, "Ubicacion 1");
        boolean resultado = ubicacionRepoImplementacion.guardarUbicacion(ubicacion);
        Assertions.assertTrue(resultado);
    }

}
