package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.persistence.repositoryImplementacion.UbicacionObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:UbicacionObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:UbicacionObtenerDespues.sql")
})
public class UbicacionObtenerPorIdDataTest {
    @Inject
    UbicacionObtenerPorIdRepoImplementacion miUbicacionObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerUbicacionPorId_DevuelveUbicacion() {
        Assertions.assertNotNull(miUbicacionObtenerPorIdRepoImplementacion.obtenerUbicacion(1));
    }

    @Test
    public void obtenerUbicacionPorId_DevuelveNull() {
        Assertions.assertNull(miUbicacionObtenerPorIdRepoImplementacion.obtenerUbicacion(3));
    }
}
