package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.persistence.repositoryImplementacion.FichaObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:FichaObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:FichaObtenerDespues.sql")
})
public class FichaObtenerPorIdDataTest {
    @Inject
    FichaObtenerPorIdRepoImplementacion miFichaObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerFichaPorId_DevuelveFicha() {
        Assertions.assertNotNull(miFichaObtenerPorIdRepoImplementacion.obtenerFicha(1));
    }

    @Test
    public void obtenerFichaPorId_DevuelveNull() {
        Assertions.assertNull(miFichaObtenerPorIdRepoImplementacion.obtenerFicha(3));
    }
}
