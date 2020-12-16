package com.ar.genesis.sistema.tipomovimiento.data;

import com.ar.genesis.sistema.tipomovimiento.persistence.implementation.TipoMovimientoObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoMovimientoObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoMovimientoObtenerDespues.sql")
})
public class TipoMovimientoObtenerPorIdDataTest {
    @Inject
    TipoMovimientoObtenerPorIdRepoImplementacion miTipoMovimientoObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerTipoMovimientoPorId_DevuelveTipoMovimiento() {
        Assertions.assertNotNull(miTipoMovimientoObtenerPorIdRepoImplementacion.obtenerTipoMovimiento(1));
    }

    @Test
    public void obtenerTipoMovimientoPorId_DevuelveNull() {
        Assertions.assertNull(miTipoMovimientoObtenerPorIdRepoImplementacion.obtenerTipoMovimiento(3));
    }
}
