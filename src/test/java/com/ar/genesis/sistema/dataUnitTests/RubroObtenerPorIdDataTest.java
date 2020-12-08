package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.persistence.repositoryImplementacion.RubroObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:RubroObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:RubroObtenerDespues.sql")
})
public class RubroObtenerPorIdDataTest {
    @Inject
    RubroObtenerPorIdRepoImplementacion miRubroObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerRubroPorId_DevuelveRubro() {
        Assertions.assertNotNull(miRubroObtenerPorIdRepoImplementacion.obtenerRubro(1));
    }

    @Test
    public void obtenerRubroPorId_DevuelveNull() {
        Assertions.assertNull(miRubroObtenerPorIdRepoImplementacion.obtenerRubro(3));
    }
}
