package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.persistence.repositoryImplementacion.ProvinciaObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ProvinciaObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ProvinciaObtenerDespues.sql")
})
public class ProvinciaObtenerPorIdDataTest {
    @Inject
    ProvinciaObtenerPorIdRepoImplementacion miProvinciaObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerProvinciaPorId_DevuelveProvincia() {
        Assertions.assertNotNull(miProvinciaObtenerPorIdRepoImplementacion.obtenerProvincia(1));
    }

    @Test
    public void obtenerProvinciaPorId_DevuelveNull() {
        Assertions.assertNull(miProvinciaObtenerPorIdRepoImplementacion.obtenerProvincia(3));
    }
}
