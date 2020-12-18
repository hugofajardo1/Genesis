package com.ar.genesis.sistema.puntoventaTest.data;

import com.ar.genesis.sistema.puntoventa.persistence.implementation.PuntoVentaObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:PuntoVentaObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:PuntoVentaObtenerDespues.sql")
})
public class PuntoVentaObtenerPorIdDataTest {
    @Inject
    PuntoVentaObtenerPorIdRepoImplementacion miPuntoVentaObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerPuntoVentaPorId_DevuelvePuntoVenta() {
        Assertions.assertNotNull(miPuntoVentaObtenerPorIdRepoImplementacion.obtenerPuntoVenta(1));
    }

    @Test
    public void obtenerPuntoVentaPorId_DevuelveNull() {
        Assertions.assertNull(miPuntoVentaObtenerPorIdRepoImplementacion.obtenerPuntoVenta(3));
    }
}
