package com.ar.genesis.sistema.tipooperacionTest.data;

import com.ar.genesis.sistema.tipooperacion.persistence.implementation.TipoOperacionObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoOperacionObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoOperacionObtenerDespues.sql")
})
public class TipoOperacionObtenerPorIdDataTest {
    @Inject
    TipoOperacionObtenerPorIdRepoImplementacion miTipoOperacionObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerTipoOperacionPorId_DevuelveTipoOperacion() {
        Assertions.assertNotNull(miTipoOperacionObtenerPorIdRepoImplementacion.obtenerTipoOperacion(1));
    }

    @Test
    public void obtenerTipoOperacionPorId_DevuelveNull() {
        Assertions.assertNull(miTipoOperacionObtenerPorIdRepoImplementacion.obtenerTipoOperacion(3));
    }
}
