package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.persistence.repositoryImplementacion.TipoIvaObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoIvaObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoIvaObtenerDespues.sql")
})
public class TipoIvaObtenerPorIdDataTest {
    @Inject
    TipoIvaObtenerPorIdRepoImplementacion miTipoIvaObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerTipoIvaPorId_DevuelveTipoIva() {
        Assertions.assertNotNull(miTipoIvaObtenerPorIdRepoImplementacion.obtenerTipoIva(1));
    }

    @Test
    public void obtenerTipoIvaPorId_DevuelveNull() {
        Assertions.assertNull(miTipoIvaObtenerPorIdRepoImplementacion.obtenerTipoIva(3));
    }
}
