package com.ar.genesis.sistema.movimientoTest.data;

import com.ar.genesis.sistema.movimiento.persistence.implementation.MovimientoObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:MovimientoObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:MovimientoObtenerDespues.sql")
})
public class MovimientoObtenerPorIdDataTest {
    @Inject
    MovimientoObtenerPorIdRepoImplementacion miMovimientoObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerMovimientoPorId_DevuelveMovimiento() {
        Assertions.assertNotNull(miMovimientoObtenerPorIdRepoImplementacion.obtenerMovimiento(1));
    }

    @Test
    public void obtenerMovimientoPorId_DevuelveNull() {
        Assertions.assertNull(miMovimientoObtenerPorIdRepoImplementacion.obtenerMovimiento(3));
    }
}
